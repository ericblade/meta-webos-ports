SUMMARY = "Android in a Box - Android image"
DESCRIPTION = "Android image file for Anbox"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"

# works only for following 4 archs
COMPATIBLE_MACHINE ?= "(^$)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"
COMPATIBLE_MACHINE_armv7a = "(.*)"
COMPATIBLE_MACHINE_armv7ve = "(.*)"
COMPATIBLE_MACHINE_aarch64 = "(.*)"

ANDROID_IMAGE_x86-64 = "android_3_amd64.img"
ANDROID_RELEASE_x86-64 = "2017/07/13"
MD5SUM_x86-64 = "b48ad4e671eeade99e55c3625784cac8"
SHA256SUM_x86-64 = "20caeb254d716610bab2c94cd360a92353e48860fdc7cb21c16e0eab74bc42d0"

ANDROID_IMAGE_armv7a = "android_1_armhf.img"
ANDROID_IMAGE_armv7ve = "android_1_armhf.img"
ANDROID_RELEASE_armv7a = "2017/06/12"
ANDROID_RELEASE_armv7ve = "2017/06/12"
MD5SUM_armv7a = "c25f967a87ba588694535e01c5f40070"
MD5SUM_armv7ve = "c25f967a87ba588694535e01c5f40070"
SHA256SUM_armv7a = "8507f7ac92b4b48983e6069e65f6f9709a27510ed8ef8b19bc8f2369b7c144fd"
SHA256SUM_armv7ve = "8507f7ac92b4b48983e6069e65f6f9709a27510ed8ef8b19bc8f2369b7c144fd"

ANDROID_IMAGE_aarch64 = "android_1_arm64.img"
ANDROID_RELEASE_aarch64 = "2017/08/04"
MD5SUM_aarch64 = "b3f743e4cc1b486bd1c6f4fc40c58f24"
SHA256SUM_aarch64 = "e52da14ab5ee6f5274a102193d7e92382a1a7b5b87154f8cf280037bfa7ddb0b"

SRC_URI = "http://build.anbox.io/android-images/${ANDROID_RELEASE}/${ANDROID_IMAGE}"

SRC_URI[md5sum] = "${MD5SUM}"
SRC_URI[sha256sum] = "${SHA256SUM}"

do_install() {
    install -d ${D}${localstatedir}/lib/anbox
    install -m 0644 ${WORKDIR}/${ANDROID_IMAGE} ${D}${localstatedir}/lib/anbox/android.img
}

FILES_${PN} += "${webos_execstatedir}/anbox"
