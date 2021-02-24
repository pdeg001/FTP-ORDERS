package nl.pdeg.ftporder;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "nl.pdeg.ftporder", "nl.pdeg.ftporder.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "nl.pdeg.ftporder.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _ftp_user = "";
public static String _ftp_pass = "";
public static String _ftp_url = "";
public static int _ftp_port = 0;
public static int _ftpreloaddata = 0;
public static String _appfolder = "";
public static boolean _storelogininfo = false;
public b4a.example.dateutils _dateutils = null;
public nl.pdeg.ftporder.main _main = null;
public nl.pdeg.ftporder.xuiviewsutils _xuiviewsutils = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 31;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return false;
}
public static nl.pdeg.ftporder.main._ftpdata  _createftpdata(String _username,String _url,int _port) throws Exception{
nl.pdeg.ftporder.main._ftpdata _t1 = null;
 //BA.debugLineNum = 60;BA.debugLine="Public Sub CreateftpData (username As String, url";
 //BA.debugLineNum = 61;BA.debugLine="Dim t1 As ftpData";
_t1 = new nl.pdeg.ftporder.main._ftpdata();
 //BA.debugLineNum = 62;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 63;BA.debugLine="t1.username = username";
_t1.username /*String*/  = _username;
 //BA.debugLineNum = 64;BA.debugLine="t1.url = url";
_t1.url /*String*/  = _url;
 //BA.debugLineNum = 65;BA.debugLine="t1.port = port";
_t1.port /*int*/  = _port;
 //BA.debugLineNum = 66;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return null;
}
public static String  _getappfolder() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub GetAppFolder As String";
 //BA.debugLineNum = 51;BA.debugLine="Return appFolder";
if (true) return _appfolder;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getftpdata() throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
 //BA.debugLineNum = 42;BA.debugLine="Public Sub GetFtpData As List";
 //BA.debugLineNum = 43;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 44;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 45;BA.debugLine="lst.Add(CreateftpData (ftp_user, ftp_url, ftp_por";
_lst.Add((Object)(_createftpdata(_ftp_user,_ftp_url,_ftp_port)));
 //BA.debugLineNum = 47;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return null;
}
public static String  _getsetappfolder() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Private Sub GetSetAppFolder";
 //BA.debugLineNum = 39;BA.debugLine="appFolder = rp.GetSafeDirDefaultExternal(\"\")";
_appfolder = _rp.GetSafeDirDefaultExternal("");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getstoredinfo() throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
 //BA.debugLineNum = 76;BA.debugLine="Public Sub GetStoredInfo As List";
 //BA.debugLineNum = 77;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 78;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 80;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getstorelogininfo() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Public Sub GetStoreLoginInfo As List";
 //BA.debugLineNum = 70;BA.debugLine="If File.Exists(appFolder, \"si\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_appfolder,"si")) { 
 //BA.debugLineNum = 71;BA.debugLine="StoreLoginInfo = True";
_storelogininfo = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 72;BA.debugLine="Return GetStoredInfo";
if (true) return _getstoredinfo();
 };
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 11;BA.debugLine="Private ftp_user, ftp_pass, ftp_url As String";
_ftp_user = "";
_ftp_pass = "";
_ftp_url = "";
 //BA.debugLineNum = 12;BA.debugLine="Private ftp_port, ftpReloadData As Int";
_ftp_port = 0;
_ftpreloaddata = 0;
 //BA.debugLineNum = 14;BA.debugLine="Private appFolder As String";
_appfolder = "";
 //BA.debugLineNum = 15;BA.debugLine="Public StoreLoginInfo As Boolean";
_storelogininfo = false;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 19;BA.debugLine="GetSetAppFolder";
_getsetappfolder();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 23;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _setdummyftp() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Public Sub SetDummyFTP";
 //BA.debugLineNum = 55;BA.debugLine="ftp_url = \"ftp.vhcjongensbv.nl\"";
_ftp_url = "ftp.vhcjongensbv.nl";
 //BA.debugLineNum = 56;BA.debugLine="ftp_user = \"weegschaal\"";
_ftp_user = "weegschaal";
 //BA.debugLineNum = 57;BA.debugLine="ftp_pass = \"Jongens21!@#\"";
_ftp_pass = "Jongens21!@#";
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
}
