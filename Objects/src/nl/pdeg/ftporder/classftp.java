package nl.pdeg.ftporder;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class classftp extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "nl.pdeg.ftporder.classftp");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", nl.pdeg.ftporder.classftp.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.net.FTPWrapper _ftp = null;
public b4a.example.dateutils _dateutils = null;
public nl.pdeg.ftporder.main _main = null;
public nl.pdeg.ftporder.starter _starter = null;
public nl.pdeg.ftporder.xuiviewsutils _xuiviewsutils = null;
public String  _initialize(nl.pdeg.ftporder.classftp __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="classftp";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="CreateConnectionObj";
__ref._createconnectionobj /*String*/ (null);
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public String  _getfolders(nl.pdeg.ftporder.classftp __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="classftp";
if (Debug.shouldDelegate(ba, "getfolders", false))
	 {return ((String) Debug.delegate(ba, "getfolders", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Public Sub GetFolders";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="FTP.List(\"../\")";
__ref._ftp /*anywheresoftware.b4a.net.FTPWrapper*/ .List(ba,"../");
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(nl.pdeg.ftporder.classftp __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="classftp";
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim FTP As FTP";
_ftp = new anywheresoftware.b4a.net.FTPWrapper();
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
public String  _createconnectionobj(nl.pdeg.ftporder.classftp __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="classftp";
if (Debug.shouldDelegate(ba, "createconnectionobj", false))
	 {return ((String) Debug.delegate(ba, "createconnectionobj", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Public Sub CreateConnectionObj";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="FTP.Initialize(\"FTP\", Starter.ftp_url, Starter.ft";
__ref._ftp /*anywheresoftware.b4a.net.FTPWrapper*/ .Initialize(ba,"FTP",_starter._ftp_url /*String*/ ,_starter._ftp_port /*int*/ ,_starter._ftp_user /*String*/ ,_starter._ftp_pass /*String*/ );
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="FTP.PassiveMode = True";
__ref._ftp /*anywheresoftware.b4a.net.FTPWrapper*/ .setPassiveMode(__c.True);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="FTP.TimeoutMs = 3000";
__ref._ftp /*anywheresoftware.b4a.net.FTPWrapper*/ .TimeoutMs = (int) (3000);
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="End Sub";
return "";
}
public String  _ftp_listcompleted(nl.pdeg.ftporder.classftp __ref,String _serverpath,boolean _success,anywheresoftware.b4a.net.FTPWrapper.FTPFileWrapper[] _folders,anywheresoftware.b4a.net.FTPWrapper.FTPFileWrapper[] _files) throws Exception{
__ref = this;
RDebugUtils.currentModule="classftp";
if (Debug.shouldDelegate(ba, "ftp_listcompleted", false))
	 {return ((String) Debug.delegate(ba, "ftp_listcompleted", new Object[] {_serverpath,_success,_folders,_files}));}
int _i = 0;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub FTP_ListCompleted (ServerPath As String, Succe";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Log(ServerPath)";
__c.LogImpl("71835009",_serverpath,0);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="If Success = False Then";
if (_success==__c.False) { 
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="Log(LastException)";
__c.LogImpl("71835011",BA.ObjectToString(__c.LastException(getActivityBA())),0);
 }else {
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="For i = 0 To Folders.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_folders.length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="Log(Folders(i).Name)";
__c.LogImpl("71835014",_folders[_i].getName(),0);
 }
};
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="For i = 0 To Files.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_files.length-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="Log(Files(i).Name & \", \" & Files(i).Size & \", \"";
__c.LogImpl("71835017",_files[_i].getName()+", "+BA.NumberToString(_files[_i].getSize())+", "+__c.DateTime.Date(_files[_i].getTimestamp()),0);
 }
};
 };
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="End Sub";
return "";
}
}