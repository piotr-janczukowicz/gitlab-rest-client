package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;

public final class GroupepicboardsCatalogFixtures {

    private GroupepicboardsCatalogFixtures() {}

    public static GitLabEpicBoard epicBoard() {
        return GitLabEpicBoardBuilder.builder()
                .id(1L)
                .name("Team Board")
                .hideBacklogList(true)
                .hideClosedList(true)
                .group(CommonCatalogFixtures.basicGroupDetails())
                .labels(List.of(CommonCatalogFixtures.labelBasic()))
                .lists(List.of(GroupepicboardsCatalogFixtures.epicBoardsList()))
                .build();
    }

    public static GitLabEpicBoardsList epicBoardsList() {
        return GitLabEpicBoardsListBuilder.builder()
                .id(1L)
                .label(CommonCatalogFixtures.labelBasic())
                .position(1)
                .listType("backlog")
                .build();
    }
}
