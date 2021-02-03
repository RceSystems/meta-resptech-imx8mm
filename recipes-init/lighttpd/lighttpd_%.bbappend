do_install_append() {
  sed -i '/PIDFile=\/run\/lighttpd.*/a ExecStartPre=install -d -o lighttpd -g lighttpd \/www\/logs\/lighttpd' ${D}/lib/systemd/system/lighttpd.service
}  
