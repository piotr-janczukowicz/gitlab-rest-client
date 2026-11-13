package io.github.piotr_janczukowicz.gitlab.api.appearance;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab appearance.
 *
 * @param title the title
 * @param description the description
 * @param pwaName the pwa name
 * @param pwaShortName the pwa short name
 * @param pwaDescription the pwa description
 * @param logo the logo
 * @param pwaIcon the pwa icon
 * @param headerLogo the header logo
 * @param favicon the favicon
 * @param newProjectGuidelines the new project guidelines
 * @param memberGuidelines the member guidelines
 * @param profileImageGuidelines the profile image guidelines
 * @param headerMessage the header message
 * @param footerMessage the footer message
 * @param messageBackgroundColor the message background color
 * @param messageFontColor the message font color
 * @param emailHeaderAndFooterEnabled the email header and footer enabled
 * @param siteName the site name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAppearance")
public record GitLabAppearance(
        @Nullable String title,
        @Nullable String description,
        @Nullable String pwaName,
        @Nullable String pwaShortName,
        @Nullable String pwaDescription,
        @Nullable String logo,
        @Nullable String pwaIcon,
        @Nullable String headerLogo,
        @Nullable String favicon,
        @Nullable String newProjectGuidelines,
        @Nullable String memberGuidelines,
        @Nullable String profileImageGuidelines,
        @Nullable String headerMessage,
        @Nullable String footerMessage,
        @Nullable String messageBackgroundColor,
        @Nullable String messageFontColor,
        @Nullable Boolean emailHeaderAndFooterEnabled,
        @Nullable String siteName) {}
