B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.6
@EndOfDesignText@
#IgnoreWarnings: 10
Sub Class_Globals
	Dim FTP As FTP
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	CreateConnectionObj
End Sub

Public Sub CreateConnectionObj
	FTP.Initialize("FTP", Starter.ftp_url, Starter.ftp_port, Starter.ftp_user, Starter.ftp_pass)
	FTP.PassiveMode = True
	FTP.TimeoutMs = 3000
End Sub

Public Sub GetFolders
	FTP.List("/../")
End Sub

Sub FTP_ListCompleted (ServerPath As String, Success As Boolean, Folders() As FTPEntry, Files() As FTPEntry)
	Log(ServerPath)
	If Success = False Then
		Log(LastException.Message)
	Else
		For i = 0 To Folders.Length - 1
			Log(Folders(i).Name)
		Next
		For i = 0 To Files.Length - 1
			Log(Files(i).Name & ", " & Files(i).Size & ", " & DateTime.Date(Files(i).Timestamp))
		Next
	End If
End Sub