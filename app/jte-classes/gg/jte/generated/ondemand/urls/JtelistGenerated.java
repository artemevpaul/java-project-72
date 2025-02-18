package gg.jte.generated.ondemand.urls;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.UrlsPage;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "urls/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,5,5,7,7,25,25,29,29,29,33,33,33,33,33,33,33,33,33,33,33,33,36,36,42,42,42,42,42,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <main class=\"flex-grow-1\">\n\n        <section>\n\n            <div class=\"container-lg mt-5\">\n                <h1>Сайты</h1>\n\n                <table class=\"table table-bordered table-hover mt-3\">\n\n                    <thead>\n                    <tr>\n                        <th class=\"col-1\">ID</th>\n                        <th>Имя</th>\n                        <th class=\"col-2\">Последняя проверка</th>\n                        <th class=\"col-1\">Код ответа</th>\n                    </tr>\n                    </thead>\n                    ");
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
					jteOutput.writeContent("</a>\n                        </td>\n                    </tr>\n                    ");
				}
				jteOutput.writeContent("\n                    </tbody>\n                </table>\n            </div>\n        </section>\n    </main>\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
