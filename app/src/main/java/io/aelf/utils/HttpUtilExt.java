package io.aelf.utils;

import android.util.Log;

import io.aelf.utils.network.NetworkConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtilExt {


  /**
   * HTTP GET Request help method.
   */
  public static String sendGet(String reqUrl,
      String decodeCharset, String version) throws Exception {
    Log.e("HttpUtilExt","Request address:" + reqUrl);
    if (StringUtil.isBlank(version)) {
      version = "";
    } else {
      version = ";v=" + version;
    }
    String chainContext = NetworkConnector.getIns().sendGet(reqUrl, decodeCharset, "application/json" + version);
    if (StringUtil.toString(chainContext).length() > 0 && chainContext.contains("@ERROR:@")) {
      chainContext = chainContext.replace("@ERROR:@", "");
      throw new RuntimeException(chainContext);
    }
    Log.e("HttpUtilExt","Return parameters:" + chainContext);
    return chainContext;
  }

  /**
   * HTTP DELETE Request help method.
   */
  public static String sendDelete(String reqUrl, String decodeCharset, String version, String basicAuth) {
    Log.e("HttpUtilExt","Request address:" + reqUrl);
    if (StringUtil.isBlank(version)) {
      version = "";
    } else {
      version = ";v=" + version;
    }
    String chainContext = NetworkConnector.getIns()
        .sendDelete(reqUrl, decodeCharset, "application/json" + version, basicAuth);
    Log.e("HttpUtilExt","Return parameters:" + chainContext);
    return chainContext;
  }

  /**
   * HTTP POST Request help method.
   */
  public static String sendPost(String reqUrl, String params, String version) throws Exception {
    if (StringUtil.isBlank(version)) {
      version = "";
    } else {
      version = ";v=" + version;
    }
    Log.e("HttpUtilExt","Request address:" + reqUrl);
    String chainContext = NetworkConnector.getIns()
        .sendPost(reqUrl, params, "UTF-8", "UTF-8", "application/json" + version);
    if (StringUtil.toString(chainContext).length() > 0 && chainContext.contains("@ERROR:@")) {
      chainContext = chainContext.replace("@ERROR:@", "");
      throw new RuntimeException(chainContext);
    }
    Log.e("HttpUtilExt","Return parameters:" + chainContext);
    return chainContext;
  }

  /**
   * HTTP POST Request help method.
   */
  public static String sendPostWithAuth(String reqUrl, String params, String version, String authBasic) throws Exception {
    if (StringUtil.isBlank(version)) {
      version = "";
    } else {
      version = ";v=" + version;
    }
    Log.e("HttpUtilExt","Request address:" + reqUrl);
    String chainContext = NetworkConnector.getIns()
            .sendPostWithAuth(reqUrl, params, "UTF-8", "UTF-8", "application/json" + version, authBasic);
    if (StringUtil.toString(chainContext).length() > 0 && chainContext.contains("@ERROR:@")) {
      chainContext = chainContext.replace("@ERROR:@", "");
      throw new RuntimeException(chainContext);
    }
    Log.e("HttpUtilExt","Return parameters:" + chainContext);
    return chainContext;
  }
}
