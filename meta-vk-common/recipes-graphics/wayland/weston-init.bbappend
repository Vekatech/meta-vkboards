
do_install_append() {
    # The configuration of HDMI resolution
#	echo "[output]" >> ${D}/${sysconfdir}/xdg/weston/weston.ini
#	echo "name=HDMI-A-1" >> ${D}/${sysconfdir}/xdg/weston/weston.ini
#	echo "mode=1920x1080@60.00" >> ${D}/${sysconfdir}/xdg/weston/weston.ini

    cat <<EOF >>  ${D}/${sysconfdir}/xdg/weston/weston.ini

[output]
name=HDMI-A-1
mode=1920x1080@60.00
EOF

}

# Define the function to append data to the file
#append_data() {
#    cat <<EOF >>  ${D}${sysconfdir}/xdg/weston/weston.ini
#Line 1 of appended data
#Line 2 of appended data
#Line 3 of appended data
#EOF
#}

