# drop the bits that drag in GTK/X11
PACKAGECONFIG_remove  = "gcr admin"

# stop the recipe from insisting on an x11 distro feature
REQUIRED_DISTRO_FEATURES_remove = "x11"

#do_install:prepend () {
#    install -d -m 0700 ${D}${datadir}/polkit-1/rules.d
#}

#FILES_${PN} -= "${datadir}/polkit-1/rules.d"
#RDEPENDS_${PN} += "polkit"

