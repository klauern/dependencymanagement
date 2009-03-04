class TooltipTagLib {

  static namespace = "tooltip"

  def resources = {attrs ->
    out << """
        <link rel="stylesheet" href="${createLinkTo(dir: pluginContextPath, file: 'css/tooltip/default/tooltip.css')}"/>
        <script type="text/javascript" src="${createLinkTo(dir: pluginContextPath, file: "js/tooltip/tooltip-min.js")}"></script>
           """
  }

  def tip = {attrs, body ->
    assert attrs.value
    attrs.value = attrs.value.trim().encodeAsHTML()
    out << """<span onmouseover="tooltip.show('${attrs.value}');" onmouseout="tooltip.hide();">${body()}</span>"""
  }

}
