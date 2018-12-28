package com.maiguoer.component.http.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Create by www.lijin@foxmail.com on 2018/12/16 0016.
 * <br/>
 */

public class Utils {

    /**
     * 获取网络情况
     *
     * @param context
     * @return <ul>
     * <li>-1.无网络</li>
     * <li>0.其他</li>
     * <li>1.wifi</li>
     * <li>2.2G</li>
     * <li>3.3G</li>
     * <li>4.4G</li>
     * </ul>
     * @author ben75(http://stackoverflow.com/users/1818045/ben75)
     */
    public static int GetNetworkStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        // 未连接
        if (info == null || !info.isConnected())
            // 无网络
            return -1;
        if (info.getType() == ConnectivityManager.TYPE_WIFI)
            // wifi
            return 1;
        if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int networkType = info.getSubtype();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                    // 2G
                    return 2;
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
                case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
                    // 3G
                    return 3;
                case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
                    // 4G
                    return 4;
                default:
                    // 其他
                    return 0;
            }
        }
        // 其他
        return 0;
    }

    /**
     * MD5加密
     * 对字符串进行MD5加密
     *
     * @param string
     * @return
     */
    public static String stringToMD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

}
