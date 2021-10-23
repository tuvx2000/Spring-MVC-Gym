package Momo.allinone.processor.allinone;

import Momo.shared.utils.Encoder;
import Momo.shared.utils.LogUtils;
import Momo.allinone.models.RefundMoMoRequest;
import Momo.allinone.models.RefundMoMoResponse;
import Momo.shared.constants.Parameter;
import Momo.shared.constants.RequestType;
import Momo.shared.exception.MoMoException;
import Momo.shared.sharedmodels.AbstractProcess;
import Momo.shared.sharedmodels.Environment;
import Momo.shared.sharedmodels.HttpResponse;

public class RefundMoMo extends AbstractProcess<RefundMoMoRequest, RefundMoMoResponse> {

    public RefundMoMo(Environment environment) {
        super(environment);
    }

    public static RefundMoMoResponse process(Environment env, String requestId, String orderId, String amount, String transId) throws Exception {
        try {
            RefundMoMo refundMoMo = new RefundMoMo(env);

            RefundMoMoRequest request = refundMoMo.createRefundRequest(requestId, orderId, amount, transId);
            RefundMoMoResponse response = refundMoMo.execute(request);
            return response;
        } catch (Exception exception) {
            LogUtils.error("[RefundMoMoProcess] "+ exception);
        }
        return null;
    }

    public RefundMoMoResponse execute(RefundMoMoRequest request) throws MoMoException {
        try {
            String payload = getGson().toJson(request, RefundMoMoRequest.class);

            HttpResponse response = execute.sendToMoMo(environment.getMomoEndpoint(), payload);

            if (response.getStatus() != 200) {
                throw new MoMoException("[RefundMoMoResponse] [" + request.getOrderId() + "] -> Error API");
            }

            RefundMoMoResponse refundMoMoResponse = getGson().fromJson(response.getData(), RefundMoMoResponse.class);

//            errorMoMoProcess(refundMoMoResponse.getErrorCode());
            String rawData = Parameter.PARTNER_CODE + "=" + refundMoMoResponse.getPartnerCode() +
                    "&" + Parameter.ACCESS_KEY + "=" + refundMoMoResponse.getAccessKey() +
                    "&" + Parameter.REQUEST_ID + "=" + refundMoMoResponse.getRequestId() +
                    "&" + Parameter.ORDER_ID + "=" + refundMoMoResponse.getOrderId() +
                    "&" + Parameter.ERROR_CODE + "=" + refundMoMoResponse.getErrorCode() +
                    "&" + Parameter.TRANS_ID + "=" + refundMoMoResponse.getTransId() +
                    "&" + Parameter.MESSAGE + "=" + refundMoMoResponse.getMessage() +
                    "&" + Parameter.LOCAL_MESSAGE + "=" + refundMoMoResponse.getLocalMessage() +
                    "&" + Parameter.REQUEST_TYPE + "=" + RequestType.REFUND_MOMO_WALLET;

            String signature = Encoder.signHmacSHA256(rawData, partnerInfo.getSecretKey());
            LogUtils.info("[RefundMoMoResponse] rawData: " + rawData + ", [Signature] -> " + signature + ", [MoMoSignature] -> " + refundMoMoResponse.getSignature());

            if (signature.equals(refundMoMoResponse.getSignature())) {
                return refundMoMoResponse;
            } else {
                throw new MoMoException("Wrong signature from MoMo side - please contact with us");
            }
        } catch (Exception e) {
            LogUtils.error("[RefundMoMoProcess] "+ e);
        }
        return null;
    }

    public RefundMoMoRequest createRefundRequest(String requestId, String orderId, String amount, String transId) {
        String signature = "";

        try {
            String rawData =
                    Parameter.PARTNER_CODE + "=" + partnerInfo.getPartnerCode() +
                            "&" + Parameter.ACCESS_KEY + "=" + partnerInfo.getAccessKey() +
                            "&" + Parameter.REQUEST_ID + "=" + requestId +
                            "&" + Parameter.AMOUNT + "=" + amount +
                            "&" + Parameter.ORDER_ID + "=" + orderId +
                            "&" + Parameter.TRANS_ID + "=" + transId +
                            "&" + Parameter.REQUEST_TYPE + "=" + RequestType.REFUND_MOMO_WALLET;
            signature = Encoder.signHmacSHA256(rawData, partnerInfo.getSecretKey());

            LogUtils.debug("[RefundMoMoRequest] rawData: " + rawData + ", [Signature] -> " + signature);
        } catch (Exception e) {
            LogUtils.error("[RefundMoMoProcess] "+ e);
        }

        RefundMoMoRequest request = new RefundMoMoRequest(partnerInfo.getPartnerCode(),orderId,partnerInfo.getAccessKey(),amount,signature,requestId,RequestType.REFUND_MOMO_WALLET,transId);
        return request;
    }
}
