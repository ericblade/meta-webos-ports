# Copyright (c) 2012-2019 LG Electronics, Inc.

require nodejs-module-webos.inc

SUMMARY = "A module for nodejs that allows Javascript access to the webOS system bus"
AUTHOR = "Anatolii Sakhnik <anatolii.sakhnik@lge.com>"

DEPENDS += "glib-2.0 luna-service2"

PV = "3.0.1-1+git${SRCPV}"
SRCREV = "88f38bcb2d6d148c3e328efff0c2300b13dce443"

inherit webos_system_bus

do_configure() {
    export GYP_DEFINES="sysroot=${STAGING_DIR_HOST}"
    # used by binding.gyp
    export webos_servicesdir="${webos_servicesdir}" webos_prefix="${webos_prefix}"
    node-gyp --arch ${TARGET_ARCH} --nodedir "${WORKDIR}/node-v${NODE_VERSION}" configure
}

do_compile() {
    export GYP_DEFINES="sysroot=${STAGING_DIR_HOST}"
    # used by binding.gyp
    export webos_servicesdir="${webos_servicesdir}" webos_prefix="${webos_prefix}"
    node-gyp --arch ${TARGET_ARCH} build
}

WEBOS_NODE = "webos-sysbus.node"
do_install_append() {
    install ${S}/src/palmbus.js ${D}${libdir}/nodejs/palmbus.js

    # XXX Temporarily add symlink to old location until all users of it are changed
    ln -svnf ${libdir}/nodejs/palmbus.js ${D}${webos_prefix}/nodejs/palmbus.js

    # The CMake build did this with macros
    install -d ${D}${webos_sysbus_prvrolesdir}
    sed "s|@WEBOS_INSTALL_BINDIR@|$bindir|" < ${S}/files/sysbus/com.webos.nodejs.json.prv.in > ${D}${webos_sysbus_prvrolesdir}/com.webos.nodejs.json
    install -d ${D}${webos_sysbus_pubrolesdir}
    sed "s|@WEBOS_INSTALL_BINDIR@|$bindir|" < ${S}/files/sysbus/com.webos.nodejs.json.pub.in > ${D}${webos_sysbus_pubrolesdir}/com.webos.nodejs.json
}
