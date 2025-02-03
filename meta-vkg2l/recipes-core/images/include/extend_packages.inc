# extend packages
COMPATIBLE_MACHINE_vkrzg2l = "vkrzg2l"
COMPATIBLE_MACHINE_vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE_vkcmg2lc = "vkcmg2lc"
COMPATIBLE_MACHINE_vk-d184280e = "vk-d184280e"
COMPATIBLE_MACHINE_vkrzg2ul = "vkrzg2ul"

IMAGE_INSTALL_append = " \
        libgpiod \
        "

IMAGE_INSTALL_append_vkrzg2lc = " \
        kernel-devsrc \
        kernel-modules \
        kernel-dev \
        libjpeg-turbo-dev \
        kernel-module-udmabuf \
        "

IMAGE_INSTALL_append_vk-d184280e = " \
        kernel-module-udmabuf \
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

