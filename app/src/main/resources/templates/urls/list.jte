@importhexlet.code.util.NamedRoutes
@import hexlet.code.dto.UrlsPage
@param UrlsPage page


@template.layout.page(
page = page,
content = @`
    <main class="flex-grow-1">

        <section>

            <div class="container-lg mt-5">
                <h1>Сайты</h1>

                <table class="table table-bordered table-hover mt-3">

                    <thead>
                    <tr>
                        <th class="col-1">ID</th>
                        <th>Имя</th>
                        <th class="col-2">Последняя проверка</th>
                        <th class="col-2">Код ответа</th>
                    </tr>
                    </thead>
                    @for(var url : page.getUrls())
                    <tbody>
                    <tr>
                        <td>
                            ${url.getId()}
                        </td>

                        <td>
                            <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>
                        </td>
                        <td>${page.getLatestChecks().isEmpty() || page.getLatestChecks().get(url.getId()) == null ? "Проверка не проводилась" : page.getLatestChecks().get(url.getId()).getCreatedAt().toString()}</td>
                        <td>${page.getLatestChecks().isEmpty() || page.getLatestChecks().get(url.getId()) == null ? "Проверка не проводилась" : String.valueOf(page.getLatestChecks().get(url.getId()).getStatusCode())}</td>
                    </tr>
                    @endfor
                    </tbody>
                </table>
            </div>
        </section>
    </main>
`
)