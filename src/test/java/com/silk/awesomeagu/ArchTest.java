package com.silk.awesomeagu;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.silk.awesomeagu");

        noClasses()
            .that()
                .resideInAnyPackage("com.silk.awesomeagu.service..")
            .or()
                .resideInAnyPackage("com.silk.awesomeagu.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.silk.awesomeagu.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
