<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body style="font-family: Arial; font-size: 12pt; background-color: #EEE">
                <xsl:for-each select="element/Student">
                <div style="background-color: teal; color: blue; padding: 5px">
                    <span style="font-weight: bold"> <xsl:value-of select="NameStudent"/> - </span>
                    <span style="font-weight: bold"> <xsl:value-of select="Age"/> - </span>
                    <span style="font-weight: bold"> <xsl:value-of select="FormStuding"/> - </span>
                </div>
            </xsl:for-each>
                <xsl:for-each select="element2/Student">
                    <div style="background-color: teal; color: blue; padding: 5px">
                        <span style="font-weight: bold"> <xsl:value-of select="NameStudent"/> - </span>
                        <span style="font-weight: bold"> <xsl:value-of select="Age"/> - </span>
                        <span style="font-weight: bold"> <xsl:value-of select="FormStuding"/> - </span>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>