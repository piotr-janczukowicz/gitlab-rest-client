package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDataManagementChecksumPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenIdentifiersIsNullable() {
        final GitLabDataManagementChecksumPayloadBuilder builder = GitLabDataManagementChecksumPayloadBuilder.builder(
                        DatamanagementCatalogFixtures.dataManagementChecksumPayload())
                .identifiers(null);

        final GitLabDataManagementChecksumPayload built = builder.build();

        assertThat(built.identifiers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumStateIsNullable() {
        final GitLabDataManagementChecksumPayloadBuilder builder = GitLabDataManagementChecksumPayloadBuilder.builder(
                        DatamanagementCatalogFixtures.dataManagementChecksumPayload())
                .checksumState(null);

        final GitLabDataManagementChecksumPayload built = builder.build();

        assertThat(built.checksumState()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDataManagementChecksumPayload value = DatamanagementCatalogFixtures.dataManagementChecksumPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.identifiers()).isEqualTo(List.of("identifiers"));
            softly.assertThat(value.checksumState()).isEqualTo(GitLabDataManagementChecksumState.STARTED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDataManagementChecksumPayload original =
                DatamanagementCatalogFixtures.dataManagementChecksumPayload();

        final GitLabDataManagementChecksumPayload rebuilt =
                GitLabDataManagementChecksumPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenIdentifiersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("identifiers"));
        final GitLabDataManagementChecksumPayload built = GitLabDataManagementChecksumPayloadBuilder.builder(
                        DatamanagementCatalogFixtures.dataManagementChecksumPayload())
                .identifiers(source)
                .build();
        source.clear();

        assertThat(built.identifiers()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIdentifiersIsRead() {
        final GitLabDataManagementChecksumPayload built = DatamanagementCatalogFixtures.dataManagementChecksumPayload();
        final List<String> values = built.identifiers();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDataManagementChecksumPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("identifiers", "checksumState");
    }
}
