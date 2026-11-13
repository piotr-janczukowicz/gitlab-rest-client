module io.github.piotr_janczukowicz.gitlabrestclient {
    requires transitive io.github.piotr_janczukowicz.gitlabclient;
    requires org.jspecify;
    requires static io.soabase.recordbuilder.core;
    requires static java.compiler;

    // generated:exports begin
    exports io.github.piotr_janczukowicz.gitlab.api;
    exports io.github.piotr_janczukowicz.gitlab.api.accessrequests;
    exports io.github.piotr_janczukowicz.gitlab.api.accesstokens;
    exports io.github.piotr_janczukowicz.gitlab.api.activecontext;
    exports io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;
    exports io.github.piotr_janczukowicz.gitlab.api.agents;
    exports io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts;
    exports io.github.piotr_janczukowicz.gitlab.api.analytics;
    exports io.github.piotr_janczukowicz.gitlab.api.appearance;
    exports io.github.piotr_janczukowicz.gitlab.api.applications;
    exports io.github.piotr_janczukowicz.gitlab.api.attestations;
    exports io.github.piotr_janczukowicz.gitlab.api.auditevents;
    exports io.github.piotr_janczukowicz.gitlab.api.authn;
    exports io.github.piotr_janczukowicz.gitlab.api.avatar;
    exports io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;
    exports io.github.piotr_janczukowicz.gitlab.api.branches;
    exports io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;
    exports io.github.piotr_janczukowicz.gitlab.api.clusterdiscoverycertificatebaseddeprecated;
    exports io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;
    exports io.github.piotr_janczukowicz.gitlab.api.codesearch;
    exports io.github.piotr_janczukowicz.gitlab.api.codesnippets;
    exports io.github.piotr_janczukowicz.gitlab.api.codesuggestions;
    exports io.github.piotr_janczukowicz.gitlab.api.commits;
    exports io.github.piotr_janczukowicz.gitlab.api.common;
    exports io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;
    exports io.github.piotr_janczukowicz.gitlab.api.composerdistributions;
    exports io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;
    exports io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;
    exports io.github.piotr_janczukowicz.gitlab.api.containerregistry;
    exports io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;
    exports io.github.piotr_janczukowicz.gitlab.api.customattributes;
    exports io.github.piotr_janczukowicz.gitlab.api.databasedictionary;
    exports io.github.piotr_janczukowicz.gitlab.api.databasemigrations;
    exports io.github.piotr_janczukowicz.gitlab.api.datamanagement;
    exports io.github.piotr_janczukowicz.gitlab.api.debiandistributions;
    exports io.github.piotr_janczukowicz.gitlab.api.debianpackages;
    exports io.github.piotr_janczukowicz.gitlab.api.dependencies;
    exports io.github.piotr_janczukowicz.gitlab.api.dependencylistexports;
    exports io.github.piotr_janczukowicz.gitlab.api.dependencymanagement;
    exports io.github.piotr_janczukowicz.gitlab.api.dependencyproxy;
    exports io.github.piotr_janczukowicz.gitlab.api.deploykeys;
    exports io.github.piotr_janczukowicz.gitlab.api.deployments;
    exports io.github.piotr_janczukowicz.gitlab.api.deploytokens;
    exports io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;
    exports io.github.piotr_janczukowicz.gitlab.api.discussions;
    exports io.github.piotr_janczukowicz.gitlab.api.dockerfiletemplates;
    exports io.github.piotr_janczukowicz.gitlab.api.draftnotes;
    exports io.github.piotr_janczukowicz.gitlab.api.emojireactions;
    exports io.github.piotr_janczukowicz.gitlab.api.environments;
    exports io.github.piotr_janczukowicz.gitlab.api.epicissues;
    exports io.github.piotr_janczukowicz.gitlab.api.epiclinks;
    exports io.github.piotr_janczukowicz.gitlab.api.epics;
    exports io.github.piotr_janczukowicz.gitlab.api.errortracking;
    exports io.github.piotr_janczukowicz.gitlab.api.events;
    exports io.github.piotr_janczukowicz.gitlab.api.experiments;
    exports io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;
    exports io.github.piotr_janczukowicz.gitlab.api.featureflags;
    exports io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;
    exports io.github.piotr_janczukowicz.gitlab.api.freezeperiods;
    exports io.github.piotr_janczukowicz.gitlab.api.geo;
    exports io.github.piotr_janczukowicz.gitlab.api.geonodes;
    exports io.github.piotr_janczukowicz.gitlab.api.geosites;
    exports io.github.piotr_janczukowicz.gitlab.api.gitignoretemplates;
    exports io.github.piotr_janczukowicz.gitlab.api.gitlabcicdyamltemplates;
    exports io.github.piotr_janczukowicz.gitlab.api.gitlabduo;
    exports io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;
    exports io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;
    exports io.github.piotr_janczukowicz.gitlab.api.glql;
    exports io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration;
    exports io.github.piotr_janczukowicz.gitlab.api.goproxy;
    exports io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;
    exports io.github.piotr_janczukowicz.gitlab.api.groupbadges;
    exports io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;
    exports io.github.piotr_janczukowicz.gitlab.api.groupepicboards;
    exports io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;
    exports io.github.piotr_janczukowicz.gitlab.api.groupintegrations;
    exports io.github.piotr_janczukowicz.gitlab.api.groupissueboards;
    exports io.github.piotr_janczukowicz.gitlab.api.groupiterations;
    exports io.github.piotr_janczukowicz.gitlab.api.grouplabels;
    exports io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;
    exports io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;
    exports io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables;
    exports io.github.piotr_janczukowicz.gitlab.api.groupmarkdownuploads;
    exports io.github.piotr_janczukowicz.gitlab.api.groupmilestones;
    exports io.github.piotr_janczukowicz.gitlab.api.groupplaceholderreassignments;
    exports io.github.piotr_janczukowicz.gitlab.api.grouppushrules;
    exports io.github.piotr_janczukowicz.gitlab.api.groupreleases;
    exports io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves;
    exports io.github.piotr_janczukowicz.gitlab.api.groups;
    exports io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings;
    exports io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates;
    exports io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;
    exports io.github.piotr_janczukowicz.gitlab.api.groupwikis;
    exports io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;
    exports io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;
    exports io.github.piotr_janczukowicz.gitlab.api.instanceclusters;
    exports io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;
    exports io.github.piotr_janczukowicz.gitlab.api.integrations;
    exports io.github.piotr_janczukowicz.gitlab.api.invitations;
    exports io.github.piotr_janczukowicz.gitlab.api.issueboards;
    exports io.github.piotr_janczukowicz.gitlab.api.issuelinks;
    exports io.github.piotr_janczukowicz.gitlab.api.issues;
    exports io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;
    exports io.github.piotr_janczukowicz.gitlab.api.iterations;
    exports io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions;
    exports io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;
    exports io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;
    exports io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation;
    exports io.github.piotr_janczukowicz.gitlab.api.jobs;
    exports io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;
    exports io.github.piotr_janczukowicz.gitlab.api.keys;
    exports io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;
    exports io.github.piotr_janczukowicz.gitlab.api.labels;
    exports io.github.piotr_janczukowicz.gitlab.api.ldap;
    exports io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;
    exports io.github.piotr_janczukowicz.gitlab.api.license;
    exports io.github.piotr_janczukowicz.gitlab.api.linkedepics;
    exports io.github.piotr_janczukowicz.gitlab.api.markdown;
    exports io.github.piotr_janczukowicz.gitlab.api.markdownuploads;
    exports io.github.piotr_janczukowicz.gitlab.api.mavenrepository;
    exports io.github.piotr_janczukowicz.gitlab.api.memberroles;
    exports io.github.piotr_janczukowicz.gitlab.api.members;
    exports io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;
    exports io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;
    exports io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;
    exports io.github.piotr_janczukowicz.gitlab.api.mergerequests;
    exports io.github.piotr_janczukowicz.gitlab.api.mergetrains;
    exports io.github.piotr_janczukowicz.gitlab.api.metadata;
    exports io.github.piotr_janczukowicz.gitlab.api.migrations;
    exports io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;
    exports io.github.piotr_janczukowicz.gitlab.api.modelregistry;
    exports io.github.piotr_janczukowicz.gitlab.api.namespaces;
    exports io.github.piotr_janczukowicz.gitlab.api.notes;
    exports io.github.piotr_janczukowicz.gitlab.api.notificationsettings;
    exports io.github.piotr_janczukowicz.gitlab.api.npmrepository;
    exports io.github.piotr_janczukowicz.gitlab.api.nugetpackages;
    exports io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;
    exports io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates;
    exports io.github.piotr_janczukowicz.gitlab.api.orbit;
    exports io.github.piotr_janczukowicz.gitlab.api.organizations;
    exports io.github.piotr_janczukowicz.gitlab.api.packages;
    exports io.github.piotr_janczukowicz.gitlab.api.pagesdomains;
    exports io.github.piotr_janczukowicz.gitlab.api.pagessettings;
    exports io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;
    exports io.github.piotr_janczukowicz.gitlab.api.pipelines;
    exports io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;
    exports io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;
    exports io.github.piotr_janczukowicz.gitlab.api.planlimits;
    exports io.github.piotr_janczukowicz.gitlab.api.projectaliases;
    exports io.github.piotr_janczukowicz.gitlab.api.projectbadges;
    exports io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;
    exports io.github.piotr_janczukowicz.gitlab.api.projectclusters;
    exports io.github.piotr_janczukowicz.gitlab.api.projectforks;
    exports io.github.piotr_janczukowicz.gitlab.api.projectimport;
    exports io.github.piotr_janczukowicz.gitlab.api.projectimportexport;
    exports io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles;
    exports io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;
    exports io.github.piotr_janczukowicz.gitlab.api.projectmilestones;
    exports io.github.piotr_janczukowicz.gitlab.api.projectpushrules;
    exports io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;
    exports io.github.piotr_janczukowicz.gitlab.api.projectrepositorystoragemoves;
    exports io.github.piotr_janczukowicz.gitlab.api.projects;
    exports io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings;
    exports io.github.piotr_janczukowicz.gitlab.api.projectsnippets;
    exports io.github.piotr_janczukowicz.gitlab.api.projectstarring;
    exports io.github.piotr_janczukowicz.gitlab.api.projectstatistics;
    exports io.github.piotr_janczukowicz.gitlab.api.projecttemplates;
    exports io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;
    exports io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;
    exports io.github.piotr_janczukowicz.gitlab.api.projectwikis;
    exports io.github.piotr_janczukowicz.gitlab.api.protectedbranches;
    exports io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;
    exports io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;
    exports io.github.piotr_janczukowicz.gitlab.api.protectedpackages;
    exports io.github.piotr_janczukowicz.gitlab.api.protectedtags;
    exports io.github.piotr_janczukowicz.gitlab.api.pullmirroring;
    exports io.github.piotr_janczukowicz.gitlab.api.pypipackages;
    exports io.github.piotr_janczukowicz.gitlab.api.releaselinks;
    exports io.github.piotr_janczukowicz.gitlab.api.releases;
    exports io.github.piotr_janczukowicz.gitlab.api.remotemirrors;
    exports io.github.piotr_janczukowicz.gitlab.api.repositories;
    exports io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;
    exports io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules;
    exports io.github.piotr_janczukowicz.gitlab.api.resourcegroup;
    exports io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents;
    exports io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;
    exports io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents;
    exports io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;
    exports io.github.piotr_janczukowicz.gitlab.api.resourceweightevents;
    exports io.github.piotr_janczukowicz.gitlab.api.rollouts;
    exports io.github.piotr_janczukowicz.gitlab.api.rubygems;
    exports io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;
    exports io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;
    exports io.github.piotr_janczukowicz.gitlab.api.runners;
    exports io.github.piotr_janczukowicz.gitlab.api.saml;
    exports io.github.piotr_janczukowicz.gitlab.api.scim;
    exports io.github.piotr_janczukowicz.gitlab.api.search;
    exports io.github.piotr_janczukowicz.gitlab.api.searchadmin;
    exports io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;
    exports io.github.piotr_janczukowicz.gitlab.api.servicedata;
    exports io.github.piotr_janczukowicz.gitlab.api.settings;
    exports io.github.piotr_janczukowicz.gitlab.api.sidekiq;
    exports io.github.piotr_janczukowicz.gitlab.api.sidekiqmetrics;
    exports io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration;
    exports io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves;
    exports io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;
    exports io.github.piotr_janczukowicz.gitlab.api.statistics;
    exports io.github.piotr_janczukowicz.gitlab.api.suggestions;
    exports io.github.piotr_janczukowicz.gitlab.api.systemhooks;
    exports io.github.piotr_janczukowicz.gitlab.api.tags;
    exports io.github.piotr_janczukowicz.gitlab.api.terraformmodules;
    exports io.github.piotr_janczukowicz.gitlab.api.terraformstate;
    exports io.github.piotr_janczukowicz.gitlab.api.todos;
    exports io.github.piotr_janczukowicz.gitlab.api.tokenexchange;
    exports io.github.piotr_janczukowicz.gitlab.api.topics;
    exports io.github.piotr_janczukowicz.gitlab.api.unleash;
    exports io.github.piotr_janczukowicz.gitlab.api.userapplications;
    exports io.github.piotr_janczukowicz.gitlab.api.useremailaddresses;
    exports io.github.piotr_janczukowicz.gitlab.api.userfollowandunfollow;
    exports io.github.piotr_janczukowicz.gitlab.api.usermoderation;
    exports io.github.piotr_janczukowicz.gitlab.api.users;
    exports io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;
    exports io.github.piotr_janczukowicz.gitlab.api.usertokens;
    exports io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;
    exports io.github.piotr_janczukowicz.gitlab.api.vscode;
    exports io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;
    exports io.github.piotr_janczukowicz.gitlab.api.vulnerabilityfindings;
    exports io.github.piotr_janczukowicz.gitlab.api.webcommits;

    opens io.github.piotr_janczukowicz.gitlab.api.accessrequests to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.accesstokens to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.activecontext to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.agents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.analytics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.appearance to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.applications to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.attestations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.auditevents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.authn to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.avatar to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.branches to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.broadcastmessages to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.clusterdiscoverycertificatebaseddeprecated to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.codesearch to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.codesnippets to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.codesuggestions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.commits to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.common to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.composerdistributions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.conanv1distributions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.conanv2distributions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.containerregistry to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.customattributes to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.databasedictionary to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.databasemigrations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.datamanagement to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.debiandistributions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.debianpackages to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.dependencies to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.dependencylistexports to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.dependencymanagement to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.dependencyproxy to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.deploykeys to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.deployments to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.deploytokens to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.discussions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.dockerfiletemplates to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.draftnotes to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.emojireactions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.environments to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.epicissues to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.epiclinks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.epics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.errortracking to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.events to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.experiments to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.featureflags to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.freezeperiods to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.geo to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.geonodes to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.geosites to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.gitignoretemplates to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.gitlabcicdyamltemplates to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.gitlabduo to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.glql to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.goproxy to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupbadges to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupepicboards to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupimportandexport to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupintegrations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupissueboards to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupiterations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.grouplabels to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupmarkdownuploads to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupmilestones to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupplaceholderreassignments to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.grouppushrules to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupreleases to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groups to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupwebhooks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.groupwikis to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.instanceclusters to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.integrations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.invitations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.issueboards to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.issuelinks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.issues to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.issuesstatistics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.iterations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.jobs to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.jobsartifacts to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.keys to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.knowledgegraph to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.labels to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.ldap to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.license to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.linkedepics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.markdown to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.markdownuploads to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mavenrepository to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.memberroles to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.members to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mergerequests to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mergetrains to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.metadata to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.migrations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.modelregistry to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.namespaces to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.notes to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.notificationsettings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.npmrepository to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.nugetpackages to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.offlinetransfers to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.orbit to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.organizations to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.packages to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pagesdomains to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pagessettings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pipelines to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pipelineschedules to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.planlimits to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectaliases to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectbadges to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectclusters to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectforks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectimport to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectimportexport to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectmilestones to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectpushrules to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectrepositorystoragemoves to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projects to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectsnippets to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectstarring to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectstatistics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projecttemplates to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectwebhooks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.projectwikis to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.protectedbranches to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.protectedenvironments to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.protectedpackages to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.protectedtags to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pullmirroring to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.pypipackages to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.releaselinks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.releases to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.remotemirrors to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.repositories to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.repositoryfiles to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.resourcegroup to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.resourcestateevents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.resourceweightevents to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.rollouts to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.rubygems to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.runnercontrollers to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.runners to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.saml to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.scim to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.search to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.searchadmin to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.serviceaccounts to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.servicedata to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.settings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.sidekiq to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.sidekiqmetrics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.statistics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.suggestions to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.systemhooks to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.tags to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.terraformmodules to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.terraformstate to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.todos to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.tokenexchange to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.topics to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.unleash to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.userapplications to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.useremailaddresses to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.userfollowandunfollow to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.usermoderation to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.users to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.usertokens to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.vscode to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.vulnerabilities to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.vulnerabilityfindings to
            tools.jackson.databind,
            common.core;
    opens io.github.piotr_janczukowicz.gitlab.api.webcommits to
            tools.jackson.databind,
            common.core;
// generated:exports end
}
