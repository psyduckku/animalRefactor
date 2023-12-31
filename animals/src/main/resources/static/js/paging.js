
window.onload = () => {
    const list = [[${response.list}]];
    const pagination = [[${response.pagination}]];
    const params = [[${params}]];
    let num = pagination.totalRecordCount - ((params.page - 1) * params.recordSize);
    drawPage(pagination, params);
}


function drawPage(pagination, params){
    if(!pagination || !params){
        document.querySelector('.paging').innerHTML = '';
        throw new Error('Missing required paramters...');
    }
    let html ='';

    html =`<ul class="pagination justify-content-center">`;
    if(pagination.existPrevPage){
        html += `
                    <li class="page-item"><a href="javascript::void(0);" onclick="movePage(1)" class="page_bt first">처음</a></li>
                    <li class="page-item"><a href="javascript::void(0);" onclick="movePage(${pagination.startPage - 1})" class="page_bt prev">◀</a></li>
                        `;
    }

    for(let i = pagination.startPage; i<=pagination.endPage; i++){
        html += (i !== params.page)
            ? `<li class="page-item"><a href="javascript:void(0);" class="page-link" onclick="movePage(${i})">${i}</a></li>`
            : `<li class="page-item"><span class="on page-link" style="color: gray">${i}</span></li>`;
    }

    if(pagination.existNextPage){
        html += `
                    <li class="page-item"><a href="javascript:void();" onclick="movePage(${pagination.endPage + 1});" class="page_bt next">▶</a></li>
                    <li class="page-item"><a href="javascript:void();" onclick="movePage(${pagination.totalPageCount});" class="page_bt last">끝</a></li>
                     `;
    }
    html +=`</ul>`;

    document.querySelector('.paging').innerHTML = html;
}

function movePage(page){
    const queryParams = {
        page: (page) ? page : 1,
        recordSize: 10,
        pageSize: 10
    }

    location.href = location.pathname + '?' + new URLSearchParams(queryParams).toString();

}