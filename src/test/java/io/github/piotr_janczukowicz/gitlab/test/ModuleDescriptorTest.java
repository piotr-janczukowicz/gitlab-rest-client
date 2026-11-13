package io.github.piotr_janczukowicz.gitlab.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.module.ModuleDescriptor;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

@UnitTest
class ModuleDescriptorTest {

    private static final String ROOT = "io.github.piotr_janczukowicz.gitlab";

    @Test
    void module_shouldBeNamedAfterTheGitLabRestClient() {
        final Module module = ModuleDescriptorTest.class.getModule();

        assertSoftly(softly -> {
            softly.assertThat(module.isNamed()).isTrue();
            softly.assertThat(module.getName()).isEqualTo("io.github.piotr_janczukowicz.gitlabrestclient");
        });
    }

    @Test
    void module_shouldRequireTheClientTransitively_whenTheApiExposesItsTypes() {
        final ModuleDescriptor descriptor =
                ModuleDescriptorTest.class.getModule().getDescriptor();
        final Set<String> transitive = descriptor.requires().stream()
                .filter(requires -> requires.modifiers().contains(ModuleDescriptor.Requires.Modifier.TRANSITIVE))
                .map(ModuleDescriptor.Requires::name)
                .collect(Collectors.toSet());

        assertThat(transitive).contains("io.github.piotr_janczukowicz.gitlabclient");
    }

    @Test
    void module_shouldExportOnlyApiPackages_whenExportsAreListed() {
        final ModuleDescriptor descriptor =
                ModuleDescriptorTest.class.getModule().getDescriptor();
        final Set<String> exported = descriptor.exports().stream()
                .map(ModuleDescriptor.Exports::source)
                .collect(Collectors.toSet());

        assertThat(exported).isNotEmpty().allMatch(name -> name.startsWith(ROOT + ".api"));
    }
}
