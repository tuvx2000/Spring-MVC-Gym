package  com.xuantujava.Momo.allinone;

import  com.xuantujava.Momo.allinone.models.CaptureMoMoResponse;
import  com.xuantujava.Momo.allinone.models.PayGateResponse;
import  com.xuantujava.Momo.allinone.models.QueryStatusTransactionResponse;
import  com.xuantujava.Momo.allinone.processor.allinone.CaptureMoMo;
import  com.xuantujava.Momo.allinone.processor.allinone.PaymentResult;
import  com.xuantujava.Momo.allinone.processor.allinone.QueryStatusTransaction;
import  com.xuantujava.Momo.shared.utils.LogUtils;
import  com.xuantujava.Momo.shared.sharedmodels.Environment;

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
