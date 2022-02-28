DESCRIPTION = "Platform specific configuration files for Luna SurfaceManager compositor"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PV = "1.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://surface-manager.env \
           file://surface-manager.service \
          "

inherit systemd
SYSTEMD_SERVICE:${PN} = "surface-manager.service"

do_install() {
    install -d ${D}${sysconfdir}/surface-manager.d
    install -m 0644 ${WORKDIR}/surface-manager.env ${D}${sysconfdir}/surface-manager.d/
    
    install -d ${D}${systemd_system_unitdir}
    install -v -m 0644 ${WORKDIR}/surface-manager.service ${D}${systemd_system_unitdir}/surface-manager.service
}

FILES:${PN} += " \
    ${systemd_system_unitdir} \
    ${sysconfdir}/surface-manager.d \
"
