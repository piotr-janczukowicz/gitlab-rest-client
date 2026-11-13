# Pagination

Next: [Immutability](immutability.md) · [Guide index](README.md)

A list operation returns a `GitLabPage<T>`: one HTTP page of results, and the means to reach the rest. GitLab pages in two
ways, and the operation decides which one you get.

| Kind | Request | Notes |
|---|---|---|
| Offset | `GitLabPageRequest.byPage()` | The default. The next page is the `Link` header's `rel="next"`; `X-Next-Page` is a fallback only when there is no `Link` header |
| Keyset | `GitLabKeysetRequest.of(orderBy, sort)` | For the operations GitLab offers it on; `order_by` and `sort` are required. Faster on large collections |

```java
GitLabPage<GitLabIssue> page = gitLab.issues().project().list("my-group/my-project");

List<GitLabIssue> first = page.items();       // this HTTP page
List<GitLabIssue> every = page.all();         // follows the Link header to the end
Stream<GitLabIssue> lazy = page.stream();     // fetches the next page when it is needed
```

- **Page size.** `perPage` of the client's pagination configuration sets `per_page`; GitLab caps it at 100.
- **Page cap.** `maxPages` stops a walk that would never end, or `unlimitedPages()` removes the cap. Reaching it throws a
  pagination exception.
- **Safety.** A `Link` that leaves the API origin, or a page that repeats, stops the walk.
- **A page is not thread-safe.** Do not share one between threads.
