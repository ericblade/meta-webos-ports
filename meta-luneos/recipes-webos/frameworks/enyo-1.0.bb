# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Enyo 1.0 JavaScript application framework"
SECTION = "webos/frameworks"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PV = "1.0-128.2+git${SRCPV}"
SRCREV = "29d5729a290a62915dc15e0e555daf3e0675e688"

inherit webos_ports_fork_repo
inherit webos_filesystem_paths
#inherit webos_cmake
inherit allarch

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

WEBOS_GIT_PARAM_BRANCH = "webOS-ports/wam-sam"

do_install() {
    install -d ${D}${webos_frameworksdir}/enyo/0.10/framework
    cp -vrf ${S}/framework/* ${D}${webos_frameworksdir}/enyo/0.10/framework

    # Create symlink for enyo/1.0 (points to enyo/0.10)
    ln -vs 0.10 ${D}${webos_frameworksdir}/enyo/1.0
}

FILES:${PN} += "${webos_frameworksdir}"
