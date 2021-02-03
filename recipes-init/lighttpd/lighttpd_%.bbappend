do_install_append() {
  sed -i '/PIDFile=\/run\/lighttpd.*/a ExecStartPre=chown lighttpd:lighttpd \/www\/logs\/lighttpd' ${D}/lib/systemd/system/lighttpd.service
  sed -i '/PIDFile=\/run\/lighttpd.*/a ExecStartPre=mkdir \/www\/logs\/lighttpd' ${D}/lib/systemd/system/lighttpd.service
}  
