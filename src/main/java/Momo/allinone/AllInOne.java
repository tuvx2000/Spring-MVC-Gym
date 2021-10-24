package Momo.allinone;

import Momo.allinone.models.CaptureMoMoResponse;
import Momo.allinone.models.PayGateResponse;
import Momo.allinone.models.QueryStatusTransactionResponse;
import Momo.allinone.processor.allinone.CaptureMoMo;
import Momo.allinone.processor.allinone.PaymentResult;
import Momo.allinone.processor.allinone.QueryStatusTransaction;
import Momo.shared.utils.LogUtils;
import Momo.shared.sharedmodels.Environment;

/**
 * Demo
 */
public class AllInOne {

    /***
     * Select environment
     * You can load config from file
     * MoMo only provide once endpoint for each envs: dev and prod
     * @param args
     * @throws
     */

    public static void main(String... args) throws Exception {
        LogUtils.init();
        String requestId = String.valueOf(System.currentTimeMillis());
        String orderId = String.valueOf(System.currentTimeMillis());
        long amount = 50000;

        String orderInfo = "Pay With MoMo";
        String returnURL = "http://localhost:8080/spring-mvc/";
        String notifyURL = "http://localhost:8080/spring-mvc/";
        String extraData = "";
        String bankCode = "SML";

        Environment environment = Environment.selectEnv("dev", Environment.ProcessType.PAY_GATE);


//      Remember to change the IDs at enviroment.properties file

//        Payment Method- Phương thức thanh toán
        CaptureMoMoResponse captureMoMoResponse = CaptureMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "");
        System.out.println("xxxPAYURL:  "+captureMoMoResponse.getPayUrl());
        System.out.println("-------------------------------------------------------------------------------------");
//        Transaction Query - Kiểm tra trạng thái giao dịch
        QueryStatusTransactionResponse queryStatusTransactionResponse = QueryStatusTransaction.process(environment, orderId, requestId);
        System.out.println("-------------------------------------------------------------------------------------");

//      Process Payment Result - Xử lý kết quả thanh toán
        PayGateResponse payGateResponse = PaymentResult.process(environment,new PayGateResponse());
        System.out.println("-------------------------------------------------------------------------------------");

    }

}
