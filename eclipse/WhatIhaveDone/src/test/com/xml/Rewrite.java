package test.com.xml;

import java.util.ArrayList;
import java.util.List;

import nc.itf.sdp.webservise.autotest.IAutoTestWebService.stub.IAutoTestWebService;
import nc.itf.sdp.webservise.autotest.IAutoTestWebService.stub.IAutoTestWebServiceLocator;
import nc.itf.sdp.webservise.autotest.IAutoTestWebService.stub.IAutoTestWebServicePortType;
import nc.itf.sdp.webservise.autotest.IAutoTestWebService.stub.SubmitJunitTestResultJunitTestResult;

public class Rewrite {
    public static void main(String[] args) {
        String msg_mrp =
                "Y%D:\\nc633_fz63_7142_emma\\modules\\mmtest\\AutoTestResult\\mmpps_mpm\\CalcTestAllResults.xls";
        String message1 = "Y%D:\\autotest\\test\\AutoTest\\mmpub\\SetaTestAllResults.xls";
        String message3 = "Y%D:\\autotest\\test\\AutoTest\\mmpsm\\PsmTestAllResults.xls";
        String message2 = "Y%D:\\nc636_1\\modules\\mmtest\\AutoTestResult\\mmpps_lrp\\LrpTestAllResults.xls";
        String[] testNos0 =
                {
                    "V6.33_SF_GXYD_076", "V6.33_SF_GXYD_153", "V6.33_SF_GXYD_096", "V6.33_SF_GXYD_001",
                    "V6.33_SF_GXYD_010", "V6.33_SF_GXYD_143"
                };
        String[] testNos =
                {
                    "V6.33_SF_GXYD_008", "V6.33_SF_GXYD_021", "V6.33_SF_GXYD_022", "V6.33_SF_GXYD_101",
                    "V6.33_SF_GXYD_102", "V6.33_SF_GXYD_106", "V6.33_SF_GXYD_112", "V6.33_SF_GXYD_113",
                    "V6.33_SF_GXYD_114", "V6.33_SF_GXYD_116", "V6.33_SF_GXYD_117", "V6.33_SF_GXYD_121",
                    "V6.33_SF_GXYD_122", "V6.33_SF_GXYD_123", "V6.33_SF_GXYD_125", "V6.33_SF_GXYD_136",
                    "V6.33_SF_GXYD_146", "V6.33_SF_GXYD_147", "V6.33_SF_GXYD_149", "V6.33_SF_GXYD_143"
                };
        String[] testNos2 =
                {
                    "V6.36_psm0001", "V6.36_psm0002", "V6.36_psm0003", "V6.36_psm0004", "V6.36_psm0005",
                    "V6.36_psm0006", "V6.36_psm0007", "V6.36_psm0008", "V6.36_psm0009", "V6.36_psm0010",
                    "V6.36_psm0011", "V6.36_psm0012", "V6.36_psm0013", "V6.36_psm0014", "V6.36_psm0015",
                    "V6.36_psm0016", "V6.36_psm0017", "V6.36_psm0018", "V6.36_psm0019", "V6.36_psm0020",
                    "V6.36_psm0021", "V6.36_psm0022", "V6.36_psm0023", "V6.36_psm0024", "V6.36_psm0025",
                    "V6.36_psm0026"
                };

        String[] testNos3 =
                {
                    "V6.31-V6.3-���׷���-�����㷨����-01", "V6.31-V6.3-���׷���-�����㷨����-02", "V6.31-V6.3-���׷���-�����㷨����-03",
                    "V6.31-V6.3-���׷���-�����㷨����-04", "V6.31-V6.3-���׷���-�����㷨����-05", "V6.31-V6.3-���׷���-�����㷨����-06",
                    "V6.31-V6.3-���׷���-�����㷨����-07", "V6.31-V6.3-���׷���-�����㷨����-09", "V6.31-V6.3-���׷���-�����㷨����-10",
                    "V6.31-V6.3-���׷���-�����㷨����-11", "V6.31-V6.3-���׷���-�����㷨����-12", "V6.31-V6.3-���׷���-�����㷨����-13",
                    "V6.31-V6.3-���׷���-�����㷨����-14", "V6.31-V6.3-���׷���-�����㷨����-15", "V6.31-V6.3-���׷���-�����㷨����-16",
                    "V6.31-V6.3-���׷���-�����㷨����-17", "V6.31-V6.3-���׷���-�����㷨����-18", "V6.31-V6.3-���׷���-�����㷨����-19",
                    "V6.31-V6.3-���׷���-�����㷨����-20", "V6.31-V6.3-���׷���-�����㷨����-21", "V6.31-V6.3-���׷���-�����㷨����-22",
                    "V6.31-V6.3-���׷���-�����㷨����-23", "V6.31-V6.3-���׷���-�����㷨����-24", "V6.31-V6.3-���׷���-�����㷨����-24.01",
                    "V6.31-V6.3-���׷���-�����㷨����-25", "V6.31-V6.3-���׷���-�����㷨����-26", "V6.31-V6.3-���׷���-�����㷨����-26.01",
                    "V6.31-V6.3-���׷���-�����㷨����-27", "V6.31-V6.3-���׷���-�����㷨����-28", "V6.31-V6.3-���׷���-�����㷨����-8",
                    "V6.31-V6.3-���׷���-�����㷨����-801", "V6.31-V6.3-���׷���-�����㷨����-802", "V6.31-���׷���-�����㷨����-29.01",
                    "V6.31-���׷���-�����㷨����-29.02", "V6.31-���׷���-�����㷨����-30.01", "V6.31-���׷���-�����㷨����-30.02",
                    "V6.31-���׷���-�����㷨����-31.01", "V6.31-���׷���-�����㷨����-31.02", "V6.31-���׷���-�����㷨����-32.01",
                    "V6.31-���׷���-�����㷨����-32.02"
                };
        String[] testNos4 =
                {
                    "V6.33_SF_GXYD_042", "V6.33_SF_GXYD_055", "V6.33_SF_GXYD_059", "V6.33_SF_GXYD_076",
                    "V6.33_SF_GXYD_015", "V6.33_SF_GXYD_096", "V6.33_SF_GXYD_142", "V6.33_SF_GXYD_131",
                    "V6.33_SF_GXYD_153"
                };
        try {
            List<SubmitJunitTestResultJunitTestResult> results = new ArrayList<SubmitJunitTestResultJunitTestResult>();
            int all = 156;
            for (/* int i = 0; i < testNos2.length; i++ */int i = 100; i < 157; i++) {
                String testNum = "V6.5_SF_GXYD_";
                if (i < 10) {
                    testNum = testNum + "00" + i;
                }
                else if (i >= 10 && i < 100) {
                    testNum = testNum + "0" + i;
                }
                else if (i >= 100) {
                    testNum = testNum + i;
                }
                // testNum = "V6.5_1000011";
                SubmitJunitTestResultJunitTestResult result = new SubmitJunitTestResultJunitTestResult();
                result.setKey(testNum/* testNos2[i] */); // �������
                result.setValue(message2); // �Ƿ�ɹ���Y/N��%ʧ��ԭ��

                results.add(result);
            }

            if (results.size() > 0) {
                IAutoTestWebService service = new IAutoTestWebServiceLocator();

                IAutoTestWebServicePortType call = service.getIAutoTestWebServiceSOAP11port_http();
                call.submitJunitTestResult(results.toArray(new SubmitJunitTestResultJunitTestResult[results.size()]));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
