# Ensure user creation support is enabled
#inherit useradd

# Define the user to be created
#USERADD_PACKAGES = "${PN}"
#USERADD_PARAM_${PN} = "--system --no-create-home --user-group --home-dir ${sysconfdir}/polkit-1 polkitd"

# Create the rules directory and set correct permissions before install finishes
#do_install_prepend() {
#    install -m 700 -d ${D}${sysconfdir}/polkit-1/rules.d
#    chown polkitd:root ${D}${sysconfdir}/polkit-1/rules.d
#}

#FILES_${PN}:remove = "${datadir}/{BPN}-1"
#RDEPENDS_${PN} += "polkit"

# Let other packages also own /usr/share/polkit-1/rules.d
FILES_${PN} += "${datadir}/polkit-1/rules.d"
ALLOW_EMPTY_${PN} = "1"
