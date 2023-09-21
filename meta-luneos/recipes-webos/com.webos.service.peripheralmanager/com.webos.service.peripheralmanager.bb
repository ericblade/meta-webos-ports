# Copyright (c) 2021-2023 LG Electronics, Inc.

SUMMARY = "Peripheral Manager service for webOS OSE"
AUTHOR = "Rajesh Gopu I.V <rajeshgopu.iv@lge.com>"
SECTION = "webosose"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=89aea4e17d99a7cacdbeed46a0096b10 \
    file://oss-pkg-info.yaml;md5=2bdfe040dcf81b4038370ae96036c519 \
"

DEPENDS = "glib-2.0 libpbnjson luna-service2 pmloglib "

WEBOS_VERSION = "1.0.0-13_bbd3a51b96ef9ff375de3f9f7738e6f746b4f326"
PR = "r3"

PV = "1.0.0-13+git${SRCPV}"
SRCREV = "bbd3a51b96ef9ff375de3f9f7738e6f746b4f326"

inherit webos_cmake
inherit pkgconfig
inherit webos_system_bus
inherit webos_public_repo

SRC_URI = "${WEBOSOSE_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

WEBOS_SYSTEM_BUS_MANIFEST_TYPE = "SERVICE"

FILES:${PN} += "${base_libdir}/*"

SYSTEMD_SERVICE:${PN} += " com.webos.service.peripheralmanager.service"

RRECOMMENDS:${PN} += " \
    kernel-module-i2c-dev \
    kernel-module-spidev \
    kernel-module-spi-bcm2835 \
"
