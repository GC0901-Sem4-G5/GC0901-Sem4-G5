/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
                    $('#birthday').daterangepicker({
                        singleDatePicker: true,
                        calender_style: "picker_4"
                    }, function (start, end, label) {
                        console.log(start.toISOString(), end.toISOString(), label);
                    });
                });
                
                $(document).ready(function () {
                    $.listen('parsley:field:validate', function () {
                        validateFront();
                    });
                    $('#demo-form .btn').on('click', function () {
                        $('#demo-form').parsley().validate();
                        validateFront();
                    });
                    var validateFront = function () {
                        if (true === $('#demo-form').parsley().isValid()) {
                            $('.bs-callout-info').removeClass('hidden');
                            $('.bs-callout-warning').addClass('hidden');
                        } else {
                            $('.bs-callout-info').addClass('hidden');
                            $('.bs-callout-warning').removeClass('hidden');
                        }
                    };
                });

                $(document).ready(function () {
                    $.listen('parsley:field:validate', function () {
                        validateFront();
                    });
                    $('#demo-form2 .btn').on('click', function () {
                        $('#demo-form2').parsley().validate();
                        validateFront();
                    });
                    var validateFront = function () {
                        if (true === $('#demo-form2').parsley().isValid()) {
                            $('.bs-callout-info').removeClass('hidden');
                            $('.bs-callout-warning').addClass('hidden');
                        } else {
                            $('.bs-callout-info').addClass('hidden');
                            $('.bs-callout-warning').removeClass('hidden');
                        }
                    };
                });
                try {
                    hljs.initHighlightingOnLoad();
                } catch (err) {
                }

