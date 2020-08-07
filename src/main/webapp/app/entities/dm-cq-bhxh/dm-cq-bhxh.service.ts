import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IDmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';

type EntityResponseType = HttpResponse<IDmCqBhxh>;
type EntityArrayResponseType = HttpResponse<IDmCqBhxh[]>;

@Injectable({ providedIn: 'root' })
export class DmCqBhxhService {
  public resourceUrl = SERVER_API_URL + 'api/dm-cq-bhxhs';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/dm-cq-bhxhs';

  constructor(protected http: HttpClient) {}

  create(dmCqBhxh: IDmCqBhxh): Observable<EntityResponseType> {
    return this.http.post<IDmCqBhxh>(this.resourceUrl, dmCqBhxh, { observe: 'response' });
  }

  update(dmCqBhxh: IDmCqBhxh): Observable<EntityResponseType> {
    return this.http.put<IDmCqBhxh>(this.resourceUrl, dmCqBhxh, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IDmCqBhxh>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDmCqBhxh[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDmCqBhxh[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
