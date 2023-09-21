# Copyright (c) 2020-2023 LG Electronics, Inc.

SUMMARY = "pmscore handles device states"
AUTHOR = "Yogish S <yogish.s@lge.com>"
SECTION = "webos/libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=89aea4e17d99a7cacdbeed46a0096b10 \
    file://oss-pkg-info.yaml;md5=ceae6b60c3da8e439a7f94eb5f011878 \
"

DEPENDS = "luna-service2 glib-2.0 pmloglib libpbnjson nyx-lib"

WEBOS_VERSION = "1.0.0-11_f7dd5e7ec8cb39154634aab0d70667c29253e0be"
PR = "r1"

PV = "1.0.0-11+git${SRCPV}"
SRCREV = "f7dd5e7ec8cb39154634aab0d70667c29253e0be"

inherit pkgconfig
inherit webos_cmake
inherit webos_system_bus
inherit webos_public_repo


SRC_URI = "${WEBOSOSE_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

# http://caprica.lgsvl.com:8080/Errors/Details/1092306
# 1.0.0-5-r0/git/include/public/pmscore/PmsLogging.h:63:28: error: format not a string literal and no format arguments [-Werror=format-security]
#              pLogger->Debug(buffer);
#                             ^~~~~~
# ...
SECURITY_STRINGFORMAT = ""