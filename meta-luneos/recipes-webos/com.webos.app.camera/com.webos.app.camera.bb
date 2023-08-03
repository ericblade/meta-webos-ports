# Copyright (c) 2021-2023 LG Electronics, Inc.

SUMMARY = "Camera application"
AUTHOR = "Revanth Kumar <revanth.kumar@lge.com>"
SECTION = "webos/apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
    file://oss-pkg-info.yaml;md5=3072ffcf5bdbbc376ed21c9d378d14d5 \
"

WEBOS_VERSION = "0.0.1-13_e0d6a41faf3a3afe7529b5941306818bb21796eb"
PR = "r1"

PV = "0.0.1-13+git${SRCPV}"
SRCREV = "e0d6a41faf3a3afe7529b5941306818bb21796eb"

inherit webos_enactjs_app
inherit webos_public_repo

SRC_URI = "${WEBOSOSE_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

WEBOS_ENACTJS_APP_ID = "com.webos.app.camera"

# Workaround for network access issue during do_compile task
do_compile[network] = "1"