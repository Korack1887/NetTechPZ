<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:template match="/orders">
        <html>
            <body>
                <h2>Orders</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Animator name</th>
                        <th>Costume name</th>
                        <th>Contact Address</th>
                        <th>Contact Phone number</th>
                        <th>Contact name</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="orders[order/id=2]">
                        <tr>
                            <td><xsl:value-of select="animator/name"/></td>
                            <td><xsl:value-of select="animator/costume/name"/></td>
                            <td><xsl:value-of select="order/realisation/address"/></td>
                            <td><xsl:value-of select="order/realisation/contactPhone"/></td>
                            <td><xsl:value-of select="order/realisation/contactName"/></td>
                            <td><xsl:value-of select="price"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>