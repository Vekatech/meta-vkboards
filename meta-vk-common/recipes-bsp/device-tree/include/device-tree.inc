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

SRC_URI:vkrzg2lc = " \
    file://vkrzg2lc/vkrzg2lc.dts \
    ${@' '.join(['file://vkrzg2lc/overlays-vkrzg2lc/%s' % f for f in [ \
        'vkrz-audio.dts', 'vkrz-can.dts', 'vkrz-cm33.dts', \
        'vkrz-csi-imx219.dts', 'vkrz-dsi-av_disp2.dts', 'vkrz-dsi-kd070hdfia030.dts', \
        'vkrz-dsi-kd101wxfid045.dts', 'vkrz-dsi-vklcd-ee0700.dts', \
        'vkrz-dsi-vklcd07.dts', 'vkrz-exp-i2c2.dts', 'vkrz-exp-i2c3.dts', \
		'vkrz-exp-pwm0.dts', 'vkrz-exp-pwm1.dts', 'vkrz-exp-scfi1_rst_cts.dts', \
		'vkrz-exp-scfi1.dts', 'vkrz-exp-scfi3.dts', 'vkrz-exp-spi1.dts', \
        'vkrz-udma.dts' \
    ]])} \
    "

