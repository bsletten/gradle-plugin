package org.netkernel.gradle.util

class ModuleHelper {
    def getModuleInfo(def moduleFile) {
        new XmlSlurper().parse(moduleFile)
    }
    
    def getModuleArchiveName(def moduleFile) {
        def moduleInfo = getModuleInfo(moduleFile)
        
        def moduleName = moduleInfo.meta.identity.uri.text()
        def moduleVersion = moduleInfo.meta.identity.version.text()
        def fileName = moduleName.replaceAll(':', '.')
        
        "${fileName}-${moduleVersion}.jar"
    }
}