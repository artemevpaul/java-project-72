package gg.jte.generated.ondemand.urls;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.UrlsPage;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "urls/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,5,5,8,8,26,26,30,30,30,34,34,34,34,34,34,34,34,34,34,34,34,36,36,36,37,37,37,39,39,45,45,45,45,45,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <main class=\"flex-grow-1\">\n\n        <section>\n\n            <div class=\"container-lg mt-5\">\n                <h1>Сайты</h1>\n\n                <table class=\"table table-bordered table-hover mt-3\">\n\n                    <thead>\n                    <tr>\n                        <th class=\"col-1\">ID</th>\n                        <th>Имя</th>\n                        <th class=\"col-2\">Последняя проверка</th>\n                        <th class=\"col-2\">Код ответа</th>\n                    </tr>\n                    </thead>\n                    ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\n                    <tbody>\n                    <tr>\n                        <td>\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("\n                        </td>\n\n                        <td>\n                            <a");
					var __jte_html_attribute_0 = NamedRoutes.urlPath(url.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("</a>\n                        </td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(page.getLatestChecks().isEmpty() || page.getLatestChecks().get(url.getId()) == null ? "Проверка не проводилась" : page.getLatestChecks().get(url.getId()).getCreatedAt().toString());
					jteOutput.writeContent("</td>\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(page.getLatestChecks().isEmpty() || page.getLatestChecks().get(url.getId()) == null ? "Проверка не проводилась" : String.valueOf(page.getLatestChecks().get(url.getId()).getStatusCode()));
					jteOutput.writeContent("</td>\n                    </tr>\n                    ");
				}
				jteOutput.writeContent("\n                    </tbody>\n                </table>\n            </div>\n        </section>\n    </main>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
