package com.ll.service;


import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public  class DllInterface {
	
	public static void main(String[] args) {
		System.setProperty("jna.encoding","GBK");        
		String cPIN="123456";
		byte[] cMoney =new byte[8];
		CLibrary.INSTANCE.GetBalance(cPIN, cMoney);
		System.out.println(Integer.toString(Integer.parseInt(new String(cMoney), 16)));
		byte[] cRecinfo=new byte[460];
		short[] iRecNum=new short[1];
		CLibrary.INSTANCE.GetTradeRec("123456", cRecinfo, iRecNum);
		System.out.println(new String(cRecinfo));
		System.out.println(iRecNum[0]);
		System.out.println(new String (HexUtils.convert("00070000000000007D0100000000000120160301201001000600000034FB5E4401000000000001201603012005320005000000054C55E00100000000000120160301200521000400000000001D4C01000000000001201603011127000003000000000009C401000000000001201603010151370002000000000003E8010000000000012016030101473700010000000000006405000000000001201602291631330001000000000000640100000000000120160229115531")));
		
	}
	
//	public interface CLibrary  extends StdCallLibrary {
//		CLibrary  INSTANCE  = (CLibrary ) Native.loadLibrary("EcarBussinessApi",CLibrary.class);
//		
//		/**
//		 * ���ܣ���֧����������Ϣ
//		 * @param cFile15:���л�������
//		 * @param cFile16:�ֿ�������
//		 * @param cFile1:�綯����ר����Ϣ
//		 * @return
//		 */
//		public int GetUserFileinfo(byte[]cFile15,byte[]cFile16,byte[]cFile1);
//		/**
//		 * ���ܣ���֧����������Ϣ
//		 * @param cPIN:ԭ����
//		 * @param cRecinfo:��¼��Ϣ
//		 * @param iRecNum:��¼����
//		 * @return
//		 */
//		public int GetTradeRec(String cPIN,byte[]cRecinfo,short[] iRecNum);
//		
//		/**
//		 * ���ܣ�д����
//		 * @param cCardNo:����
//		 * @return
//		 */
//		int SetUserCardNo(String cCardNo);
//		/**
//		 * ���ܣ�д֧������Ϣ
//		 * @param cFile15:���л�������
//		 * @param Flag15:д15�ļ���ʶ
//		 * @param cFile16:�ֿ�������
//		 * @param Flag16:д16�ļ���ʶ
//		 * @param cFile1:�綯����ר����Ϣ
//		 * @param Flag1:д1�ļ���ʶ
//		 * @return
//		 */
//		int SetUserCard(String cFile15,int Flag15,String cFile16,int Flag16,String cFile1,int Flag1);
//		/**
//		 * ���ܣ��޸�����
//		 * @param cOldPIN:ԭ����
//		 * @param cNewPIN:������
//		 * @return
//		 */
//		int PinChange(String cOldPIN,String cNewPIN);
//		/**
//		 * ���ܣ���������
//		 * @param cPIN:����
//		 * @return
//		 */
//		int PinReload(String cPIN);
//		/**
//		 * ���ܣ�Ȧ��
//		 * @param cPIN:����in
//		 * @param cMoney:���out
//		 * @return
//		 */
//		int LoadMoney(String cPIN,String cMoney);
//		
//		/**
//		 * ���ܣ���ѯ���
//		 * @param cPIN������
//		 * @param cMoney�����
//		 * @return
//		 */
//		int GetBalance(String cPIN,byte[] cMoney);
//		/**
//		 * ���ܣ�Ȧ��
//		 * @param unloadmoney:��ȡ���
//		 * @param mpin:����,����Ȧ��ʱ��֤
//		 * @return
//		 */
//		int Unload(String unloadmoney,String mpin);
//		/**
//		 * ���ܣ���ȡ������¼
//		 * @param RecNum:��¼����
//		 * @param StrRec:������¼��Ϣ
//		 * @return
//		 */
//		int GetGreyRecord(byte[] RecNum,byte[]StrRec);
//		/**
//		 * ���ܣ��������
//		 * @param cPIN:����
//		 * @param cMoney:�ۿ���
//		 * @param cGreyNo:������¼��
//		 * @return
//		 */
//		int GreyUnlock(String cPIN,String cMoney,String cGreyNo);
//	}
}
