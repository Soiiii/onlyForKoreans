function toggleEdit(commentIndex) {
    const commentText = document.getElementById(`commentText${commentIndex}`);
    const commentEditInput = document.getElementById(`commentEditInput${commentIndex}`);
    const btnEdit = document.getElementById(`btn-comment-edit${commentIndex}`);
    const btnSave = document.getElementById(`btn-comment-save${commentIndex}`);

    // Toggle visibility of elemenets
    if (commentText.style.display === 'block') {
        commentText.style.display = 'none';
        commentEditInput.style.display = 'block';
        btnEdit.style.display = 'none';
        btnSave.style.display = 'block';

        // Set the input field value to the current comment text
        commentEditInput.value = commentText.textContent;
    } else {
        // If the input field is already visible, toggle it back
        commentText.style.display = 'block';
        commentEditInput.style.display = 'none';
        btnEdit.style.display = 'block';
        btnSave.style.display = 'none';
    }
}

function saveComment(commentIndex) {
    const commentEditInput = document.getElementById(`commentEditInput${commentIndex}`);
    const commentText = document.getElementById(`commentText${commentIndex}`);
    const commentIdObj = document.getElementById(`commentId${commentIndex}`);


    // Get the edited comment content
    const editedContent = commentEditInput.value;
    const commentId = commentIdObj.value;

    console.log('commentId:'+commentId)
    console.log(editedContent)
    let data = {
        content: editedContent,
        commentId: commentId
    }

    // Send the edited content to the server via an AJAX request
    $.ajax({
        type: "POST",
        url: "/api/comment/edit",
        data: JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType: "json"
    })
    .done(function(resp){
            if(resp.data == 1){
                alert("댓글 수정 완료");
                // Reload the page on success
                location.reload();
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    // Update the comment text with the edited content
    commentText.textContent = editedContent;

    // Toggle back to view mode
    toggleEdit(commentIndex);
}

function deleteComment(commentIndex) {
    const commentIdObj = document.getElementById(`commentId${commentIndex}`);

    // Get the edited comment content
    const commentId = commentIdObj.value;

    console.log('commentId:'+commentId)

    let data = {
        commentId: commentId
    }

    // Send the edited content to the server via an AJAX request
    $.ajax({
        type: "POST",
        url: "/api/comment/delete",
        data: JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType: "json"
    })
    .done(function(resp){
            if(resp.data == 1){
                alert("댓글 삭제 완료");
                // Reload the page on success
                location.reload();
            }
    }).fail(function(error){
        alert(JSON.stringify(error));
    });
}
