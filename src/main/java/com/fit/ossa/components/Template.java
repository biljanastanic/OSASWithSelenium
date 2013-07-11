package com.fit.ossa.components;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.entities.user.User;
import com.fit.ossa.pages.Index;
import com.fit.ossa.services.Authenticator;

@Import(stylesheet = {
		"context:template/css/reset.css",
		"context:template/css/grid-fluid.css",
		"context:template/css/websymbols.css",
		"context:template/css/formalize.css",
		"context:template/css/esplendido.css",
		"context:template/plugins/chosen/chosen.css",
		"context:template/plugins/ui/ui-custom.css",
		"context:template/plugins/tipsy/tipsy.css",
		"context:template/plugins/validationEngine/validationEngine.jquery.css",
		"context:template/plugins/elrte/css/elrte.min.css",
		"context:template/plugins/miniColors/jquery.miniColors.css",
		"context:template/plugins/fullCalendar/fullcalendar.css",
		"context:template/plugins/elfinder/css/elfinder.css",
		"context:template/plugins/shadowbox/shadowbox.css" }, library = {
		"context:template/js/jquery.js",
		"context:template/js/esplendido.js",
		"context:template/js/browserDetect.js",
		"context:template/js/jquery.formalize.min.js",
		"context:template/js/demo.js",
		"context:template/plugins/prefixfree.min.js",
		"context:template/plugins/jquery.uniform.min.js",
		"context:template/plugins/chosen/chosen.jquery.min.js",
		"context:template/plugins/ui/multiselect/js/ui.multiselect.js",
		"context:template/plugins/ui/ui.spinner.min.js",
		"context:template/plugins/datables/jquery.dataTables.min.js",
		"context:template/plugins/jquery.metadata.js",
		"context:template/plugins/sparkline.js",
		"context:template/plugins/progressbar.js",
		"context:template/plugins/feedback.js",
		"context:template/plugins/tipsy/jquery.tipsy.js",
		"context:template/plugins/jquery.maskedinput-1.3.min.js",
		"context:template/plugins/jquery.validate.min.js",
		"context:template/plugins/validationEngine/languages/jquery.validationEngine-en.js",
		"context:template/plugins/validationEngine/jquery.validationEngine.js",
		"context:template/plugins/jquery.elastic.js",
		"context:template/plugins/elrte/elrte.min.js",
		"context:template/plugins/miniColors/jquery.miniColors.min.js",
		"context:template/plugins/fullCalendar/fullcalendar.min.js",
		"context:template/plugins/elfinder/elfinder.min.js",
		"context:template/plugins/jquery.modal.js",
		"context:template/plugins/shadowbox/shadowbox.js",
		"context:template/plugins/jqPlot/jquery.jqplot.min.js",
		"context:template/plugins/jqPlot/plugins/jqplot.cursor.min.js",
		"context:template/plugins/jqPlot/plugins/jqplot.highlighter.min.js",
		"context:template/plugins/jqPlot/plugins/jqplot.barRenderer.min.js",
		"context:template/plugins/jqPlot/plugins/jqplot.pointLabels.min.js" })
public class Template {
	
	@Inject
	private Authenticator authenticator;
	
	private User user;

	public User getUser() {
		return authenticator.getLoggedUser();
	}
	
	public Object onActionFromLogout() {
		authenticator.logout();
		return Index.class;
	}
}
