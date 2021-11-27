<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns="http://net-tech/pz"
                xmlns:ntpz="http://net-tech/pz">
    <xsl:output method="html" doctype-public="html"/>
    <xsl:template match="ntpz:orders">
        <html>
            <body>
                <h2>Orders</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>ID</th>
                        <th>Status</th>
                        <th>Contact Address</th>
                        <th>Contact name</th>
                        <th>Contact email</th>
                        <th>Category name</th>
                        <th>Animator name</th>
                        <th>Costume name</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="ntpz:order[ntpz:id=2]">
                        <tr>
                            <td><xsl:value-of select="ntpz:id"/></td>
                            <td><xsl:value-of select="ntpz:status"/></td>
                            <td><xsl:value-of select="ntpz:details/ntpz:address"/></td>
                            <td><xsl:value-of select="ntpz:details/ntpz:user/ntpz:name"/></td>
                            <td><xsl:value-of select="ntpz:details/ntpz:user/ntpz:email"/></td>
                            <td><xsl:value-of select="ntpz:category/ntpz:name"/></td>
                            <td><table><xsl:for-each select="ntpz:category/ntpz:animators">
                                <tr><td><xsl:value-of select="ntpz:name"/></td></tr>
                            </xsl:for-each></table></td>
                            <td><table><xsl:for-each select="ntpz:category/ntpz:costumes">
                                <tr><td><xsl:value-of select="ntpz:name"/></td></tr>
                            </xsl:for-each></table></td>
                            <td><xsl:value-of select="ntpz:category/ntpz:price"></xsl:value-of></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>