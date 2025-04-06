SRC_URI:vkcmg2lc = " \
    file://vkcmg2lc/vkcmg2lc.dts \
    file://vkcmg2lc/vkcmg2lc_1.dts \
	file://vkcmg2lc/vkcmg2lc_common.dtsi \
    ${@' '.join(['file://vkcmg2lc/overlays-vkcmg2lc/%s' % f for f in [ \
        'vkrz-cm33.dts', 'vkrz-cm-scif2.dts', 'vkrz-cm-usb1.dts', \
        'vkrz-csi-ov5645.dts', 'vkrz-dsi-kd070hdfia030.dts', \
        'vkrz-dsi-kd101wxfid045.dts', 'vkrz-qspi-mx25l51245g.dts', \
        'vkrz-udma.dts', 'vkrz-sdhi1.dts' \
    ]])} \
"
