# Ensure systemd does not own the directory, but still uses it

#FILES_${PN}:remove = "${datadir}/polkit-1"

#FILES_${PN} += " \
#	${datadir}/polkit-1/actions \
#	"

RDEPENDS_${PN} += "polkit"


