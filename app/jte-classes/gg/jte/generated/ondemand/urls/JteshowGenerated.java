package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.UrlPage;
import hexlet.code.util.NamedRoutes;
@SuppressWarnings("unchecked")
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,4,4,6,6,9,9,10,10,10,10,11,11,11,14,14,18,18,18,24,24,24,28,28,28,32,32,32,38,38,38,38,38,38,38,38,38,53,53,54,54,56,56,56,57,57,57,58,58,58,59,59,59,60,60,60,61,61,61,63,63,64,64,70,70,70,70,70,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <main class=\"flex-grow-1\">\n        <div>\n            ");
				if (page != null && page.getFlash() != null) {
					jteOutput.writeContent("\n                <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-");
					jteOutput.setContext("div", "class");
					jteOutput.writeUserContent(page.getFlashType());
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\" role=\"alert\">\n                    <p class=\"m-0\">");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("</p>\n                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n        </div>\n        <section>\n            <div class=\"container-lg mt-5\">\n                <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\n\n                <table class=\"table table-bordered table-hover mt-3\">\n                    <tbody>\n                    <tr>\n                        <td>ID</td>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\n                    </tr>\n                    <tr>\n                        <td>Имя</td>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\n                    </tr>\n                    <tr>\n                        <td>Дата создания</td>\n                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getCreatedAt().toString());
				jteOutput.writeContent("</td>\n                    </tr>\n                    </tbody>\n                </table>\n                <h2 class=\"mt-5\">Проверки</h2>\n\n                <form");
				var __jte_html_attribute_0 = NamedRoutes.urlChecksPath(page.getUrl().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Запустить проверку\"/>\n                </form>\n\n                <table class=\"table table-bordered table-hover mt-3\">\n                    <thead>\n                    <tr>\n                        <th scope=\"col\">ID</th>\n                        <th scope=\"col\">Код ответа</th>\n                        <th scope=\"col\">title</th>\n                        <th scope=\"col\">h1</th>\n                        <th scope=\"col\">description</th>\n                        <th scope=\"col\">Дата проверки</th>\n                    </tr>\n                    </thead>\n                    ");
				if (page.getChecksList() != null) {
					jteOutput.writeContent("\n                        ");
					for (var urlCheck : page.getChecksList()) {
						jteOutput.writeContent("\n                            <tr>\n                                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getId());
						jteOutput.writeContent("</td>\n                                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getStatusCode());
						jteOutput.writeContent("</td>\n                                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getTitle());
						jteOutput.writeContent("</td>\n                                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getH1());
						jteOutput.writeContent("</td>\n                                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(urlCheck.getDescription());
						jteOutput.writeContent("</td>\n                                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(String.valueOf(urlCheck.getCreatedAt()));
						jteOutput.writeContent("</td>\n                            </tr>\n                        ");
					}
					jteOutput.writeContent("\n                    ");
				}
				jteOutput.writeContent("\n                </table>\n\n            </div>\n        </section>\n    </main>\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
