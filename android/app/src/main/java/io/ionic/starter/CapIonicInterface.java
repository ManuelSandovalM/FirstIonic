package io.ionic.starter;

import android.app.Activity;
import android.widget.Toast;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.PluginResult;
import com.getcapacitor.annotation.CapacitorPlugin;

public class CapIonicInterface {

  @CapacitorPlugin(name = "Echo")
  public class EchoPlugin extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
      String value = call.getString("value");
      PluginResult pluginResult = new PluginResult();

      assert value != null;
      if (value.equals("beep")) {
        this.beep();
        pluginResult.put("Success", true);
        call.successCallback(pluginResult);
      }

      JSObject ret = new JSObject();
      ret.put("value", value);
      call.resolve(ret);
    }

    void beep() {
      Activity activity = getActivity();
      Toast.makeText(getContext(), "Beep beep", Toast.LENGTH_SHORT).show();
    }

  }

}
