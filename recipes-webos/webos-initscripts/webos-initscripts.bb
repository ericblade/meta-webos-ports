# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Event-driven startup scripts for system services"
SECTION = "webos/base"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

RDEPENDS_${PN} = "upstart"

WEBOS_VERSION = "2.0.0-123_8255bd94321e3ae79a55b7572aeac8868bd560fb"

inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions
inherit webos_cmake
inherit webos_arch_indep

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
