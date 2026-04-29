# extend packages
COMPATIBLE_MACHINE_vkrzg2l = "vkrzg2l"
COMPATIBLE_MACHINE_vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE_vkcmg2lc = "vkcmg2lc"
COMPATIBLE_MACHINE_vk-d184280e = "vk-d184280e"
COMPATIBLE_MACHINE_vkrzg2ul = "vkrzg2ul"



IMAGE_INSTALL:append = " \
        kernel-modules \
        devicetree \
        "

IMAGE_INSTALL:append = " ${@oe.utils.conditional("CONFIG_WLAN_CYW43439", "1", " \
        cyw43439-fw \
        wireless-regdb-static \
        iperf3 \
        ", " ", d)} "


IMAGE_INSTALL:append:vkrzg2lc = " \
        libjpeg-turbo-dev \
        kernel-module-udmabuf \
        "

IMAGE_INSTALL:append:vk-d184280e = " \
        libubootenv \
        libubootenv-bin \
        mtd-utils \
        mmc-utils \
        i2c-tools \
        libgpiod \
        gnupg \
        gpgme \
        nano \
	udev \
        systemd-dev \
        gtk+3 \
        gvfs \
        udisks2 \
        gsettings-desktop-schemas \
        tzdata \
        glibc-utils \
        python3-pip \
        python3-pyudev \
        python3-aiohttp \
        python3-passlib \
        "

IMAGE_INSTALL:append:vk-d184280e = " ${@oe.utils.conditional("CONFIG_MXTAPP", "1", " mxt-app ", " ", d)} "


IMAGE_INSTALL:remove:vk-d184280e  += " \
        opencv \
        gstreamer \
        "

IMAGE_INSTALL_append_vkcmg2lc= " \
        libjpeg-turbo-dev \
        kernel-module-udmabuf \
        "

IMAGE_INSTALL_append_vkrzg2ul = " \
        kernel-devsrc \
        kernel-modules \
        kernel-dev \
        libjpeg-turbo-dev \
        kernel-module-udmabuf \
        "

IMAGE_INSTALL:append = " ${@oe.utils.conditional("CONFIG_HTML5", "1", " \
        chromium-ozone-wayland \
        ntp \
        ttf-sazanami-gothic \
        ttf-sazanami-mincho \
        ttf-dejavu-sans \
        ttf-dejavu-sans-mono \
        ttf-dejavu-sans-condensed \
        ttf-dejavu-serif \
        adwaita-icon-theme-cursors \
        ", " ", d)} "

PREFERRED_VERSION_nodejs-native = "14.%"

PREFERRED_VERSION_libgcrypt = "1.9.4"
PREFERRED_VERSION_libgpg-error = "1.42"
PREFERRED_VERSION_gnupg = "2.3.0"
PREFERRED_VERSION_gpgme = "1.16.0"
PREFERRED_VERSION_weston = "9.0.0"


