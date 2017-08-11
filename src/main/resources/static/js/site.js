/**
 * Created by wronskip on 11.08.2017.
 */
$(document).ready(function(){


    $("#revert").click(function(){
        var r = confirm("Do you want to revert all changes?");
        if (r == true) {
            $.post("revert");
        } else {
        }
});
});
