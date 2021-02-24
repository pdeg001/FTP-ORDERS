B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.9
@EndOfDesignText@
#IgnoreWarnings: 9, 10

#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	Private rp As RuntimePermissions
	
	Private ftp_user, ftp_pass, ftp_url As String
	Private ftp_port, ftpReloadData As Int
	
	Private appFolder As String
	Public StoreLoginInfo As Boolean
End Sub

Sub Service_Create
	GetSetAppFolder
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
End Sub

Sub Service_TaskRemoved
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Private Sub GetSetAppFolder
	appFolder = rp.GetSafeDirDefaultExternal("")
End Sub

Public Sub GetFtpData As List
	Dim lst As List
	lst.Initialize
	lst.Add(CreateftpData (ftp_user, ftp_url, ftp_port))
	
	Return lst
End Sub

Public Sub GetAppFolder As String
	Return appFolder
End Sub

Public Sub SetDummyFTP
	ftp_url = "ftp.vhcjongensbv.nl"
	ftp_user = "weegschaal"
	ftp_pass = "Jongens21!@#"
End Sub

Public Sub CreateftpData (username As String, url As String, port As Int) As ftpData
	Dim t1 As ftpData
	t1.Initialize
	t1.username = username
	t1.url = url
	t1.port = port
	Return t1
End Sub

Public Sub GetStoreLoginInfo As List
	If File.Exists(appFolder, "si") Then
		StoreLoginInfo = True
		Return GetStoredInfo
	End If
End Sub

Public Sub GetStoredInfo As List
	Dim lst As List
	lst.Initialize	
	
	Return lst
End Sub