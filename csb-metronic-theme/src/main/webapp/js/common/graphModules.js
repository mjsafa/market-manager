GraphModuleAPI = {
    TagCloud: function (word_list, tagCloud_id) {
        $(function () {
            $(tagCloud_id).jQCloud(word_list, {
                shape: "elliptic"
            });
        });
    },
    PaintGraph: function (graph, svgId, svgWidth, svgHeight, linkDistance, charge, userCenter, publishCenter, tagCenter) {
        var force = d3.layout.force()
            .charge(charge)
            .linkDistance(linkDistance)
            .size([svgWidth, svgHeight]);

        var svg = d3.select(svgId)
            .attr("width", svgWidth)
            .attr("height", svgHeight);

        force.nodes(graph.nodes)
            .links(graph.links)
            .start();

        var link = svg.selectAll(".link")
            .data(graph.links)
            .enter().append("line")
            .attr("class", "link")
            .style("stroke-width", "3");

        var node = svg.selectAll(".node")
            .data(graph.nodes)
            .enter().append("g")
            .attr("class", "node")
            .attr("id", function (d) {
                return d.uniqueId
            })
            .call(force.drag);


        var transition = d3.transition()
            .duration(750)
            .ease("linear");

        if (userCenter) {

            var pubCenter = function (d) {
                return '<div style="background-color: #fcf8e3; border: 1px solid #ccc; border-radius: 10px;">' +
                    '<img style="float: left; margin-right: 30px; margin-left: 15px" src="/so-theme/images/file_system/large/pdf.png" width="80px" height=80px">' +
                    '<p>title: ' + d.title + '</p>' +
                    '<p>name: ' + d.userName + '</p>' +
                    '<p>publishId: ' + d.uniqueId + '</p>' +
                    '</div>';
            };

            var img = function (d) {
                return '<img src=' + d.addr + '/>';
            };

            node.append("foreignObject")
                .attr("width", "250")
                .attr("height", "100")
                .attr("x", -125)
                .attr("y", -50)
                .html(pubCenter)
                .attr("class", "href")
                .on("click", function (d) {
                    return ArmanJsManager.trigger("table:mytable:publish", d.uniqueId)
                });

            svg.select("#center-div-Table foreignObject").remove();
            svg.select("#center-div-Table").append("image")
                .attr("xlink:href", function (d) {
                    return d.addr
                })
                .attr("x", function (d) {
                    return -d.w / 2
                })
                .attr("y", function (d) {
                    return -d.h / 2
                })
                .attr("width", function (d) {
                    return d.w
                })
                .attr("height", function (d) {
                    return d.h
                })

            svg.select("#center-div-Table").append("text")
                .attr("dx", 0)
                .attr("dy", "65")
                .text(function (d) {
                    return d.firstName
                });
        }
        else if (publishCenter || tagCenter) {
            node.append("image")
                .attr("xlink:href", function (d) {
                    return d.addr
                })
                .attr("x", function (d) {
                    return -d.w / 2
                })
                .attr("y", function (d) {
                    return -d.h / 2
                })
                .attr("width", function (d) {
                    return d.w
                })
                .attr("height", function (d) {
                    return d.h
                })
                .attr("class", "href")
                .on("click", function (d) {
                    return ArmanJsManager.trigger("table:mytable:user", d.uniqueId)
                });

            node.append("text")
                .attr("dx", 0)
                .attr("dy", "65")
                .text(function (d) {
                    return d.firstName
                });
            svg.select("#center-div-Table").empty();
        }

        if (publishCenter) {
            var textCenter = function (d) {
                return '<div style="background-color: #fcf8e3; border: 1px solid #ccc; border-radius: 10px;">' +
                    '<img style="float: left; margin-right: 30px; margin-left: 15px" src="/so-theme/images/file_system/large/pdf.png" width="80px" height=80px">' +
                    '<p>title: ' + d.title + '</p>' +
                    '<p>name: ' + d.userName + '</p>' +
                    '<p>publishId: ' + d.publishId + '</p>' +
                    '</div>';
            };

            svg.select("#center-div-Table").append("foreignObject")
                .attr("width", "250")
                .attr("height", "100")
                .attr("x", -125)
                .attr("y", -50)
                .html(textCenter);
        }
        else if (tagCenter) {
            svg.selectAll(".link")
                .style("stroke-width", "0");

            svg.select("#center-div-Table").append("foreignObject")
                .attr("width", "452")
                .attr("height", "452")
                .attr("x", -226)
                .attr("y", -226)
                .html('<div style="z-index: 1; border: 1px solid #ccc; border-radius: 999px; width: 450px; height: 450px; background-color: #888888;">' +
                    '<div id="table-cloud-chart-words" ' +
                    'style="background-color: #dddddd; width: 300px; height: 300px; z-index: 2;' +
                    'border: 1px solid #ccc; margin:0 auto; margin-top:75px; border-radius: 999px;"></div>' +
                    '</div>');
        }

        force.on("tick", function () {
            link.attr("x1", function (d) {
                return d.source.x;
            })
                .attr("y1", function (d) {
                    return d.source.y;
                })
                .attr("x2", function (d) {
                    return d.target.x;
                })
                .attr("y2", function (d) {
                    return d.target.y;
                });
            /*var r = 70;
             node.attr("transform", function (d) {
             return "translate(" + Math.max(r, Math.min(svgWidth - r, d.x)) + "," + Math.max(r, Math.min(svgHeight - r, d.y)) + ")";
             });*/
            node.attr("transform", function (d) {
                return "translate(" + d.x + "," + d.y + ")";
            });
        });
    }
};
