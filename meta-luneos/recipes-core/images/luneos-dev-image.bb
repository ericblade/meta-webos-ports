require luneos-image.inc

DESCRIPTION = "Developers LuneOS image"

IMAGE_FEATURES += "luneos-development"

IMAGE_FEATURES_append = " dev-pkgs dbg-pkgs"

webos_enable_devmode() {
    install -d ${IMAGE_ROOTFS}/var/luna
    install -d ${IMAGE_ROOTFS}/var/luna/preferences
    touch ${IMAGE_ROOTFS}/var/luna/dev-mode-enabled
    touch ${IMAGE_ROOTFS}/var/luna/preferences/devmode_enabled
    touch ${IMAGE_ROOTFS}/var/usb-debugging-enabled
    touch ${IMAGE_ROOTFS}/.writable_image
    echo "LUNA_NEXT_DEBUG=1" >> ${IMAGE_ROOTFS}${sysconfdir}/luna-next/environment.conf
}

ROOTFS_POSTPROCESS_COMMAND += "webos_enable_devmode;"

MESA_PKGS = " \
    libegl-mesa \
    libgles2-mesa \
    libgbm \
    mesa-megadriver \
    libgles1-mesa \
    libglapi \
"

IMAGE_INSTALL:append = " \
    libdrm-tests \
    qtbase-examples \
    qtbase-plugins \
    glmark2 \
    kernel-modules \
"

IMAGE_INSTALL:append:qemuall = " \
    ${MESA_PKGS} \
"
