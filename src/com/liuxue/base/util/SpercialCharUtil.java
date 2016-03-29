package com.liuxue.base.util;

import org.apache.commons.codec.binary.Base64;

import com.liuxue.base.Constants;


public class SpercialCharUtil {
	
	public static boolean isPureSpercialChar(String input){
		String result=null;
		result=input.replaceAll("!","")
					.replaceAll("~","")
					.replaceAll("\\$","")
					.replaceAll("&","")
					.replaceAll("\\u002A","")
					.replaceAll("\\(","")
					.replaceAll("\\)","")
					.replaceAll("=","")
					.replaceAll("\\|","")
					.replaceAll("\\{","")
					.replaceAll("\\}","")
					.replaceAll(";","")
					.replaceAll("\\?","")
					.replaceAll(">","")
					.replaceAll(",","")
					.replaceAll("\\^","")
					.replaceAll("@","")
					.replaceAll(",","")
					.replaceAll("\'","")
					.replaceAll("\"","")
					.replaceAll("-","")
					.replaceAll(" ","")
					.replaceAll("or ","")
					.replaceAll("and ","")
					.replaceAll(" or","")
					.replaceAll(" and","");
		if(result.equals(""))
			return true;
		else
			return false;
	}
	
	public static String getReplacedPureSpercialChar(String input){
		String result=null;
		result=input.replaceAll("!","")
					.replaceAll("~","")
					.replaceAll("\\$","")
					.replaceAll("&","")
					.replaceAll("\\u002A","")
					.replaceAll("\\(","")
					.replaceAll("\\)","")
					.replaceAll("=","")
					.replaceAll("\\|","")
					.replaceAll("\\{","")
					.replaceAll("\\}","")
					.replaceAll(";","")
					.replaceAll("\\?","")
					.replaceAll(">","")
					.replaceAll(",","")
					.replaceAll("\\^","")
					.replaceAll("@","")
					.replaceAll(",","")
					.replaceAll("\'","")
					.replaceAll("\"","")
					.replaceAll("-","")
					.replaceAll("or","")
					.replaceAll("and","")
					.trim();
		return result;
	}
	
	public static String encodePW(String value){
		Base64 b=new Base64();
		byte[] result=null;
		try{
			result=encode(Constants.encryptionKey.getBytes(),value.getBytes());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new String(b.encode(result));
	}
	
	public static String decodePW(String value){
		Base64 b=new Base64();
		byte[] result=null;
		try{
			result=decode(Constants.encryptionKey.getBytes(),b.decode(value.getBytes()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new String(result);
	}
	
	public static String decodePW2(String value) throws Exception{
		Base64 b=new Base64();
		byte[] result=null;
		try{
			result=decode(Constants.encryptionKey.getBytes(),b.decode(value.getBytes()));
		}catch(Exception ex){
			throw new Exception("瑙ｅ瘑鍑洪敊!");
		}
		return new String(result);
	}
	
	public static byte[] encode(byte[] key, byte[] bys) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey sk = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, sk);
        return cipher.doFinal(bys);
    }
    
    public static byte[] decode(byte[] key, byte[] bys) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey sk = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, sk);
        return cipher.doFinal(bys);
    }
    
  //生成图片名称(有扩展名)
    public static String suiJiImageName(String uploadImageName){
    	// 获取图片的扩展名
        String extensionName = uploadImageName
                .substring(uploadImageName.lastIndexOf(".") + 1);
    	 int random = (int) (Math.random() * 10000);
    	 String newFileName = String.valueOf(System.currentTimeMillis()+random)+"."+extensionName;
    	 return newFileName;
    }
    
	
	public static void main(String []args) throws Exception{
		//System.out.println(isPureSpercialChar("*"));
		String ep=encodePW("shemene");   
		System.out.println("加密密码"+ep);
		String result=decodePW("Pffp8t2SxNg=");  
//		String result=decodePW("TAaHmzDc3Dw/N56DCvM46Q==");
		System.out.println("解密密码"+result);
	}
}
